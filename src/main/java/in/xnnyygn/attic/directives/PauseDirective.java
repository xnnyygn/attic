package in.xnnyygn.attic.directives;

import in.xnnyygn.attic.Command;
import in.xnnyygn.attic.Directive;
import in.xnnyygn.attic.DirectiveContext;

public class PauseDirective implements Directive {

  private final long millisecond;

  public PauseDirective(Command command) {
    millisecond = Long.parseLong(command.getArguments().get(0));
  }

  public void execute(DirectiveContext context) {
    try {
      Thread.sleep(millisecond);
    } catch (InterruptedException e) {
    }
  }

}
