package in.xnnyygn.attic.directives.http;

import in.xnnyygn.attic.Command;
import in.xnnyygn.attic.Directive;
import in.xnnyygn.attic.DirectiveContext;

public class SetUriDirective implements Directive {

  private final String uri;

  public SetUriDirective(Command command) {
    this.uri = command.getArguments().get(0);
  }

  public void execute(DirectiveContext context) {
    context.setVariable("http.uri", uri);
  }

}
