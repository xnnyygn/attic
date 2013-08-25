package in.xnnyygn.attic.interpreter;

import in.xnnyygn.attic.api.Command;
import in.xnnyygn.attic.api.CommandArguments;

import java.util.Arrays;
import java.util.Collection;

public class DefaultCommandFactory {

  private final Collection<String> packages;

  public DefaultCommandFactory() {
    this(Arrays.asList("in.xnnyygn.attic.command"));
  }

  public DefaultCommandFactory(Collection<String> packages) {
    super();
    this.packages = packages;
  }

  public Command create(String line) {
    String[] cmdWithArgs = line.split("\\s");
    return newCommand(cmdWithArgs[0], new DefaultCommandArguments(cmdWithArgs));
  }

  private Command newCommand(String commandName, CommandArguments arguments) {
    Command command = newCommandInstance(searchCommandClass(commandName));
    command.setArguments(arguments);
    return command;
  }

  private Command newCommandInstance(Class<? extends Command> commandClass)
      throws CommandInstantiationException {
    try {
      return commandClass.newInstance();
    } catch (Exception e) {
      throw new CommandInstantiationException(String.format(
          "failed to create instance of command class [%s], cause is [%s]",
          commandClass, e.getMessage()), e);
    }
  }

  private Class<? extends Command> searchCommandClass(String commandName)
      throws NoSuchCommandException {
    for (String pkg : packages) {
      String className = pkg + '.' + commandName + "Command";
      Class<? extends Command> clazz = loadClass(className);
      if (clazz != null) return clazz;
    }
    throw new NoSuchCommandException(String.format(
        "no such command [%s] under packages %s", commandName, packages));
  }

  @SuppressWarnings("unchecked")
  private Class<? extends Command> loadClass(String className) {
    try {
      Class<?> clazz = Class.forName(className);
      if (clazz != null) return (Class<? extends Command>) clazz;
    } catch (Exception e) {
      // class not found
      // class cast exception
    }
    return null;
  }

}
