package in.xnnyygn.attic.command;

import java.io.PrintWriter;

import in.xnnyygn.attic.api.Command;
import in.xnnyygn.attic.api.CommandArguments;
import in.xnnyygn.attic.api.CommandContext;

public class PrintlnCommand implements Command {

  private PrintWriter writer = new PrintWriter(System.out);
  private String text;

  public void setWriter(PrintWriter writer) {
    this.writer = writer;
  }

  public void setArguments(CommandArguments arguments) {
    text = arguments.getParameter(1);
  }

  public void execute(CommandContext context) {
    writer.println(text);
    writer.flush();
  }

}
