package in.xnnyygn.attic.command.selenium;

import static in.xnnyygn.attic.command.selenium.SeleniumCommandVariables.WEBDRIVER;
import in.xnnyygn.attic.api.Command;
import in.xnnyygn.attic.api.CommandArguments;
import in.xnnyygn.attic.api.CommandContext;

import org.openqa.selenium.WebDriver;

public class CloseCommand implements Command {

  public void setArguments(CommandArguments arguments) {
  }

  public void execute(CommandContext context) {
    WebDriver driver = context.getVariable(WEBDRIVER);
    if (driver != null) driver.close();
  }

}
