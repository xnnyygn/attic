package in.xnnyygn.attic.command;

import in.xnnyygn.attic.api.Command;
import in.xnnyygn.attic.api.CommandArguments;
import in.xnnyygn.attic.api.CommandContext;

public class PrintlnCommand implements Command {

  private String text;

  public void setArguments(CommandArguments arguments) {
    text = arguments.get(0);
  }

  public void execute(CommandContext context) {
    System.out.println(text);
  }

}
