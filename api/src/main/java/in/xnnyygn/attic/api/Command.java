package in.xnnyygn.attic.api;

public interface Command {

  void setArguments(CommandArguments arguments);
  
  void execute(CommandContext context);
  
}
