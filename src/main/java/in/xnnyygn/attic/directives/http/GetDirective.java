package in.xnnyygn.attic.directives.http;

import in.xnnyygn.attic.Command;
import in.xnnyygn.attic.Directive;
import in.xnnyygn.attic.DirectiveContext;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class GetDirective implements Directive {

  public GetDirective(Command command) {
  }

  public void execute(DirectiveContext context) {
    try {
      System.out
          .println(IOUtils.toString(new URL(buildUrl(context)).openStream()));
    } catch (MalformedURLException e) {
      // TODO log error
    } catch (IOException e) {
      System.err.println(e);
    }
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
