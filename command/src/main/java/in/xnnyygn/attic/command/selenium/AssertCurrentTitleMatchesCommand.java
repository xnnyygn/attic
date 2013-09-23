package in.xnnyygn.attic.command.selenium;

import in.xnnyygn.attic.api.Command;
import in.xnnyygn.attic.api.CommandArguments;
import in.xnnyygn.attic.api.CommandContext;

import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import static in.xnnyygn.attic.command.selenium.SeleniumCommandVariables.WEBDRIVER;

public class AssertCurrentTitleMatchesCommand implements Command {

  private Pattern pattern;

  public void setArguments(CommandArguments arguments) {
    pattern = Pattern.compile(arguments.getParameter(1));
  }

  public void execute(CommandContext context) {
    WebDriver driver = (WebDriver) context.getVariable(WEBDRIVER);
    String title = driver.getTitle();
    if (!pattern.matcher(title).matches()) {
      throw new IllegalStateException(String.format(
          "expect pattern [%s], but was [%s]", pattern.pattern(), title));
    }
  }

}
