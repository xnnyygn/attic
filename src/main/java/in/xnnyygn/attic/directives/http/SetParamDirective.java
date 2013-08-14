package in.xnnyygn.attic.directives.http;

import in.xnnyygn.attic.Command;
import in.xnnyygn.attic.Directive;
import in.xnnyygn.attic.DirectiveContext;

import java.util.List;

public class SetParamDirective implements Directive {

  private static final String VAR_KEY = "http.params";
  private final String name;
  private final String value;

  public SetParamDirective(Command command) {
    List<String> args = command.getArguments();
    name = args.get(0);
    value = args.get(1);
  }

  public void execute(DirectiveContext context) {
    if (context.getVariable(VAR_KEY) == null) {
      context.setVariable(VAR_KEY, new HttpParams());
    }
    ((HttpParams) context.getVariable(VAR_KEY)).setParam(name, value);
  }

}
