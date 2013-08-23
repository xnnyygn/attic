package in.xnnyygn.attic.command;

import in.xnnyygn.attic.api.Command;
import in.xnnyygn.attic.api.CommandArguments;
import in.xnnyygn.attic.api.CommandContext;

public class PauseCommand implements Command {

  private long millis;

  public void setArguments(CommandArguments arguments) {
    millis = Long.parseLong(arguments.get(0));
  }

  public void execute(CommandContext context) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      // omit
    }
  }

}
