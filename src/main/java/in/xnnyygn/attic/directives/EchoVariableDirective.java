package in.xnnyygn.attic.directives;

import in.xnnyygn.attic.Command;
import in.xnnyygn.attic.Directive;
import in.xnnyygn.attic.DirectiveContext;

public class EchoVariableDirective implements Directive {

  private final String variableName;

  public EchoVariableDirective(Command command) {
    variableName = command.getArguments().get(0);
  }

  public void execute(DirectiveContext context) {
    System.out.println(context.getVariable(variableName));
  }

}
