package in.xnnyygn.attic.command.selenium;

import static in.xnnyygn.attic.command.selenium.SeleniumCommandVariables.WEBDRIVER;
import in.xnnyygn.attic.api.Command;
import in.xnnyygn.attic.api.CommandArguments;
import in.xnnyygn.attic.api.CommandContext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyTextCommand implements Command {

  private String selector;
  private String text;

  public void setArguments(CommandArguments arguments) {
    selector = arguments.get(0);
    text = arguments.get(1);
  }

  public void execute(CommandContext context) {
    WebDriver driver = context.getVariable(WEBDRIVER);
    WebElement element = driver.findElement(By.cssSelector(selector));
    if (!element.getText().equals(text)) {
      throw new RuntimeException("expect [" + text + "], but is ["
          + element.getText() + "]");
    }
  }

}
