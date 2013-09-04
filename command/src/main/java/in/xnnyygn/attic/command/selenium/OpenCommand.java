package in.xnnyygn.attic.command.selenium;

import static in.xnnyygn.attic.command.http.HttpCommandConstants.VAR_URI;
import static in.xnnyygn.attic.command.http.HttpCommandUtils.getEncoding;
import static in.xnnyygn.attic.command.http.HttpCommandUtils.getOrCreateHttpParam;
import static in.xnnyygn.attic.command.selenium.SeleniumCommandVariables.WEBDRIVER;
import in.xnnyygn.attic.api.Command;
import in.xnnyygn.attic.api.CommandArguments;
import in.xnnyygn.attic.api.CommandContext;
import in.xnnyygn.attic.command.http.HttpParams;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenCommand implements Command {

  private String url;

  public void setArguments(CommandArguments arguments) {
    if (arguments.getParameterCount() > 0) url = arguments.getParameter(1);
  }

  public void execute(CommandContext context) {
    getOrCreateWebDriver(context).get(determineUrl(context));
  }

  private String determineUrl(CommandContext context) {
    if (url != null) return url;
    String uri = context.getVariable(VAR_URI);
    HttpParams params = getOrCreateHttpParam(context);
    String queryString = params.toQueryString(getEncoding(context));
    return uri + '?' + queryString;
  }

  private WebDriver getOrCreateWebDriver(CommandContext context) {
    if (!context.containsVariable(WEBDRIVER))
      context.setVariable(WEBDRIVER, new FirefoxDriver());
    return context.getVariable(WEBDRIVER);
  }

}
