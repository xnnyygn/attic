package in.xnnyygn.attic.interpreter;

import static org.apache.commons.io.IOUtils.readLines;
import in.xnnyygn.attic.api.CommandContext;
import in.xnnyygn.attic.api.DefaultCommandContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Interpreter {

  private final DefaultCommandFactory commandFactory;

  public Interpreter() {
    this(new ArrayList<String>(0));
  }

  public Interpreter(String pkg) {
    this(Arrays.asList(pkg));
  }

  public Interpreter(Collection<String> packages) {
    commandFactory =
        new DefaultCommandFactory(addAll("in.xnnyygn.attic.command", packages));
  }

  private static <T> Collection<T> addAll(T head, Collection<T> tail) {
    List<T> l = new ArrayList<T>();
    l.add(head);
    l.addAll(tail);
    return l;
  }

  public void interpret(String fileName) throws IOException {
    interpret(readLines(new FileInputStream(fileName)));
  }

  public void interpret(Collection<String> lines) {
    CommandContext context = new DefaultCommandContext();
    for (String line : lines) {
      if (line.length() > 0 && !line.startsWith("#")) {
        commandFactory.create(line).execute(context);
      }
    }
  }

}
