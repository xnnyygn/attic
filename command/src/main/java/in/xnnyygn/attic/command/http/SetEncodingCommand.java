package in.xnnyygn.attic.command.http;

import in.xnnyygn.attic.api.Command;
import in.xnnyygn.attic.api.CommandArguments;
import in.xnnyygn.attic.api.CommandContext;

public class SetEncodingCommand implements Command {

  private String encoding;
  
  public void setArguments(CommandArguments arguments) {
    encoding = arguments.getParameter(1);
  }

  public void execute(CommandContext context) {
    context.setVariable(HttpCommandConstants.VAR_ENCODING, encoding);
  }

}
