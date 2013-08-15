package in.xnnyygn.attic.directives.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import in.xnnyygn.attic.Command;
import in.xnnyygn.attic.Directive;
import in.xnnyygn.attic.DirectiveContext;

public class VerifyTextDirective implements Directive {

  private final String selector;
  private final String text;

  public VerifyTextDirective(Command command) {
    selector = command.getArgument(1);
    text = command.getArgument(2);
  }

  public void execute(DirectiveContext context) {
    WebDriver driver = (WebDriver) context.getVariable("selenium.driver");
    WebElement element = driver.findElement(By.cssSelector(selector));
    if (!element.getText().equals(text)) {
      throw new RuntimeException("expect [" + text + "], but is ["
          + element.getText() + "]");
    }
  }

}
