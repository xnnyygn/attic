package in.xnnyygn.attic.directives;

import in.xnnyygn.attic.Command;
import in.xnnyygn.attic.Directive;

import java.util.List;

public class EchoDirective implements Directive {

  private final String text;

  public EchoDirective(Command command) {
    List<String> arguments = command.getArguments();
    text = arguments.get(0);
  }

  public void execute() {
    System.out.println(text);
  }
  
}
