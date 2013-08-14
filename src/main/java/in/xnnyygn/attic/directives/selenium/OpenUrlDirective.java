package in.xnnyygn.attic.directives.selenium;

import in.xnnyygn.attic.Command;
import in.xnnyygn.attic.Directive;
import in.xnnyygn.attic.DirectiveContext;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenUrlDirective implements Directive {

  private final String url;

  public OpenUrlDirective(Command command) {
    url = command.getArguments().get(0);
  }

  public void execute(DirectiveContext context) {
    WebDriver driver = new FirefoxDriver();
    driver.get(url);
    context.setVariable("selenium.driver", driver);
  }

}
