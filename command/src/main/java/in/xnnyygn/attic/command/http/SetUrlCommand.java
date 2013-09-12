package in.xnnyygn.attic.command.http;

import in.xnnyygn.attic.api.Command;
import static in.xnnyygn.attic.command.http.HttpCommandConstants.VAR_URL;
import in.xnnyygn.attic.api.CommandArguments;
import in.xnnyygn.attic.api.CommandContext;

public class SetUrlCommand implements Command {

  private String url;

  public void setArguments(CommandArguments arguments) {
    url = arguments.getParameter(1);
  }

  public void execute(CommandContext context) {
    context.setVariable(VAR_URL, url);
  }

}
