package in.xnnyygn.attic.command;

import in.xnnyygn.attic.api.Command;
import in.xnnyygn.attic.api.CommandArguments;
import in.xnnyygn.attic.api.CommandContext;

public class EchoVariableCommand implements Command {

  private String key;
  
  public void setArguments(CommandArguments arguments) {
    key = arguments.get(0);
  }

  public void execute(CommandContext context) {
    System.out.println(context.getVariable(key));
  }

}
