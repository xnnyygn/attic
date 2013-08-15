package in.xnnyygn.attic.directives.http;

import in.xnnyygn.attic.Command;
import in.xnnyygn.attic.Directive;
import in.xnnyygn.attic.DirectiveContext;

public class SetParamDirective implements Directive {

  private static final String VAR_KEY = "http.params";
  private final String name;
  private final String value;

  public SetParamDirective(Command command) {
    this(command.getArgument(1), command.getArgument(2));
  }

  public SetParamDirective(String name, String value) {
    this.name = name;
    this.value = value;
  }

  public void execute(DirectiveContext context) {
    if (context.getVariable(VAR_KEY) == null) {
      context.setVariable(VAR_KEY, new HttpParams());
    }
    ((HttpParams) context.getVariable(VAR_KEY)).setParam(name, value);
  }

}
