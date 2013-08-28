package in.xnnyygn.attic.command.selenium;

import static in.xnnyygn.attic.command.http.HttpCommandUtils.getOrCreateHttpParam;
import static in.xnnyygn.attic.command.http.HttpCommandVariables.URI;
import static in.xnnyygn.attic.command.selenium.SeleniumCommandVariables.WEBDRIVER;
import in.xnnyygn.attic.api.Command;
import in.xnnyygn.attic.api.CommandArguments;
import in.xnnyygn.attic.api.CommandContext;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenCommand implements Command {

  public void setArguments(CommandArguments arguments) {
  }

  public void execute(CommandContext context) {
    String uri = context.getVariable(URI);
    String queryString = getOrCreateHttpParam(context).toQueryString();
    getOrCreateWebDriver(context).get(uri + '?' + queryString);
  }

  private WebDriver getOrCreateWebDriver(CommandContext context) {
    if (!context.containsVariable(WEBDRIVER))
      context.setVariable(WEBDRIVER, new FirefoxDriver());
    return context.getVariable(WEBDRIVER);
  }

}
