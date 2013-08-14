package in.xnnyygn.attic.directives.selenium;

import in.xnnyygn.attic.Command;
import in.xnnyygn.attic.Directive;
import in.xnnyygn.attic.DirectiveContext;
import in.xnnyygn.attic.directives.http.HttpParams;

import java.io.UnsupportedEncodingException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenDirective implements Directive {
  
  public OpenDirective(Command command) {
  }

  public void execute(DirectiveContext context) {
    WebDriver driver = new FirefoxDriver();
    driver.get(buildUrl(context));
    context.setVariable("selenium.driver", driver);
  }

  private String buildUrl(DirectiveContext context) {
    String uri = (String) context.getVariable("http.uri");
    HttpParams params = (HttpParams) context.getVariable("http.params");
    try {
      String queryString = params != null ? params.toQueryString() : "";
      return uri + '?' + queryString;
    } catch (UnsupportedEncodingException e) {
      // TODO throw exception
    }
    return "";
  }

}
