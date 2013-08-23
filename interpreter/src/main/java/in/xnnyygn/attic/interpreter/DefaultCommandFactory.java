package in.xnnyygn.attic.interpreter;

import in.xnnyygn.attic.api.Command;

public class DefaultCommandFactory {

  public Command create(String line) {
    String[] commandNameWithArguments = line.split("\\s");
    Command command = newCommand(commandNameWithArguments[0]);
    command.setArguments(new DefaultCommandArguments(commandNameWithArguments));
    return command;
  }

  private Command newCommand(String commandName) {
    try {
      return (Command) Class.forName(
          "in.xnnyygn.attic.command." + commandName + "Command").newInstance();
    } catch (Exception e) {
      throw new NoSuchCommandException("no such command [" + commandName + "]",
          e);
    }
  }

}
