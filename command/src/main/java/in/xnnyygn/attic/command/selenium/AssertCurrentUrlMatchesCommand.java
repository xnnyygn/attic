package in.xnnyygn.attic.command.selenium;

import in.xnnyygn.attic.api.Command;
import in.xnnyygn.attic.api.CommandArguments;
import in.xnnyygn.attic.api.CommandContext;

import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import static in.xnnyygn.attic.command.selenium.SeleniumCommandVariables.WEBDRIVER;

public class AssertCurrentUrlMatchesCommand implements Command {

  private Pattern pattern;

  public void setArguments(CommandArguments arguments) {
    pattern = Pattern.compile(arguments.getParameter(1));
  }

  public void execute(CommandContext context) {
    WebDriver driver = context.getVariable(WEBDRIVER);
    String currentUrl = driver.getCurrentUrl();
    if (!pattern.matcher(currentUrl).matches()) {
      throw new IllegalStateException(String.format(
          "expect url pattern [%s] but is [%s]", pattern.pattern(), currentUrl));
    }
  }

}
