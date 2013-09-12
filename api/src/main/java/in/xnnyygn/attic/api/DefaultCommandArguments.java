package in.xnnyygn.attic.api;

import java.util.Arrays;
import java.util.List;

public class DefaultCommandArguments implements CommandArguments {

  private final List<String> arguments;

  public DefaultCommandArguments(String... arguments) {
    this(Arrays.asList(arguments));
  }

  public DefaultCommandArguments(List<String> arguments) {
    if (arguments.isEmpty())
      throw new IllegalArgumentException("arguments should not be empty");
    this.arguments = arguments;
  }

  public String getName() {
    return arguments.get(0);
  }

  public String getParameter(int index) {
    return arguments.get(index);
  }

  public String getParameter(int index, String defaultValue) {
    if (index > getParameterCount()) return defaultValue;
    return getParameter(index);
  }

  public int getParameterCount() {
    return arguments.size() - 1;
  }

}
