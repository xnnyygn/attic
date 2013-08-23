package in.xnnyygn.attic.interpreter;

import in.xnnyygn.attic.api.CommandArguments;

import java.util.Arrays;
import java.util.List;

public class DefaultCommandArguments implements CommandArguments {

  private final List<String> arguments;

  public DefaultCommandArguments(String[] commandNameWithArguments) {
    arguments = tail(Arrays.asList(commandNameWithArguments));
  }

  private static <T> List<T> tail(List<T> list) {
    if (list.isEmpty())
      throw new IllegalStateException("no tail of an empty list");
    return list.subList(1, list.size());
  }

  public String get(int index) {
    return arguments.get(index);
  }

}
