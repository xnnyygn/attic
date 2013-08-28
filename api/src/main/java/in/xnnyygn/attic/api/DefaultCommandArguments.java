package in.xnnyygn.attic.api;


import java.util.Arrays;
import java.util.List;

public class DefaultCommandArguments implements CommandArguments {

  private final List<String> arguments;
  
  public DefaultCommandArguments(String ... arguments) {
    this(Arrays.asList(arguments));
  }

  public DefaultCommandArguments(List<String> arguments) {
    this.arguments = arguments;
  }

  public String get(int index) {
    return arguments.get(index);
  }

}
