package in.xnnyygn.attic.command.http;

import static in.xnnyygn.attic.command.http.HttpCommandVariables.URI;
import in.xnnyygn.attic.api.Command;
import in.xnnyygn.attic.api.CommandArguments;
import in.xnnyygn.attic.api.CommandContext;

public class SetUriCommand implements Command {

  private String uri;

  public void setArguments(CommandArguments arguments) {
    uri = arguments.getParameter(1);
  }

  public void execute(CommandContext context) {
    context.setVariable(URI, uri);
  }

}
