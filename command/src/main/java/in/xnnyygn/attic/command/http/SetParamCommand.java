package in.xnnyygn.attic.command.http;

import static in.xnnyygn.attic.command.http.HttpCommandUtils.getOrCreateHttpParam;
import in.xnnyygn.attic.api.Command;
import in.xnnyygn.attic.api.CommandArguments;
import in.xnnyygn.attic.api.CommandContext;

public class SetParamCommand implements Command {

  private String name;
  private String value;

  public void setArguments(CommandArguments arguments) {
    name = arguments.getParameter(1);
    value = arguments.getParameter(2);
  }

  public void execute(CommandContext context) {
    getOrCreateHttpParam(context).set(name, value);
  }

}
