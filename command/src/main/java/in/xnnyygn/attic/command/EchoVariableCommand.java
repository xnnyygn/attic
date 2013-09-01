package in.xnnyygn.attic.command;

import in.xnnyygn.attic.api.Command;
import in.xnnyygn.attic.api.CommandArguments;
import in.xnnyygn.attic.api.CommandContext;

import java.io.PrintWriter;

public class EchoVariableCommand implements Command {

  private PrintWriter writer = new PrintWriter(System.out);
  private String key;

  public void setWriter(PrintWriter writer) {
    this.writer = writer;
  }

  public void setArguments(CommandArguments arguments) {
    key = arguments.getParameter(1);
  }

  public void execute(CommandContext context) {
    writer.println(context.getVariable(key));
    writer.flush();
  }

}
