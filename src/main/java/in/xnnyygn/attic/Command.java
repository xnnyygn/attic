package in.xnnyygn.attic;

import java.util.ArrayList;
import java.util.List;

public class Command {

  private final String name;
  private final List<String> arguments;

  public Command(String name) {
    this(name, new ArrayList<String>(0));
  }

  public Command(String name, List<String> arguments) {
    super();
    this.name = name;
    this.arguments = arguments;
  }

  public String getName() {
    return name;
  }

  public List<String> getArguments() {
    return arguments;
  }

  public String getArgument(int index) {
    if (index == 0) return name;
    return arguments.get(index - 1);
  }

  @Override
  public String toString() {
    return String.format("Command [name=%s, arguments=%s]", name, arguments);
  }

}
