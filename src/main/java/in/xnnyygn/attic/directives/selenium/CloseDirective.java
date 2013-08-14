package in.xnnyygn.attic.directives.selenium;

import in.xnnyygn.attic.Command;
import in.xnnyygn.attic.Directive;
import in.xnnyygn.attic.DirectiveContext;

import org.openqa.selenium.WebDriver;

public class CloseDirective implements Directive {

  public CloseDirective(Command command) {
  }

  public void execute(DirectiveContext context) {
    ((WebDriver) context.getVariable("selenium.driver")).close();
  }

}
