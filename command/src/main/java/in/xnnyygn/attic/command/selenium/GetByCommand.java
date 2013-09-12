package in.xnnyygn.attic.command.selenium;

import static in.xnnyygn.attic.command.http.HttpCommandConstants.VAR_URI;
import static in.xnnyygn.attic.command.http.HttpCommandConstants.VAR_URL;
import static in.xnnyygn.attic.command.http.HttpCommandUtils.*;
import static in.xnnyygn.attic.command.selenium.SeleniumCommandVariables.WEBDRIVER;
import static org.openqa.selenium.remote.BrowserType.*;
import in.xnnyygn.attic.api.Command;
import in.xnnyygn.attic.api.CommandArguments;
import in.xnnyygn.attic.api.CommandContext;
import in.xnnyygn.attic.command.http.HttpParams;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class GetByCommand implements Command {

  private String provider;

  public void setArguments(CommandArguments arguments) {
    provider = arguments.getParameter(1, FIREFOX);
  }

  public void execute(CommandContext context) {
    getOrCreateWebDriver(context).get(determineUrl(context));
  }

  private String determineUrl(CommandContext context) {
    String url = context.getVariable(VAR_URL);
    if (url != null) return url;

    String uri = context.getVariable(VAR_URI);
    HttpParams params = getOrCreateHttpParam(context);
    String queryString = params.toQueryString(getEncoding(context));
    return uri + '?' + queryString;
  }

  private WebDriver getOrCreateWebDriver(CommandContext context) {
    if (!context.containsVariable(WEBDRIVER))
      context.setVariable(WEBDRIVER, determineWebDriver());
    return context.getVariable(WEBDRIVER);
  }

  private WebDriver determineWebDriver() {
    if (FIREFOX.equals(provider)) return new FirefoxDriver();
    if (GOOGLECHROME.equals(provider)) return new ChromeDriver();
    if (IE.equals(provider)) return new InternetExplorerDriver();
    if (HTMLUNIT.equals(provider)) return new HtmlUnitDriver();
    throw new IllegalArgumentException(String.format(
        "unsupported browser type [%s]", provider));
  }

}
