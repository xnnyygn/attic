package in.xnnyygn.attic.interpreter;

import in.xnnyygn.attic.api.CommandContext;
import in.xnnyygn.attic.api.DefaultCommandContext;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

  List<String> readLines(InputStream in) throws IOException {
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new InputStreamReader(in));
      List<String> lines = new ArrayList<String>();
      String line = null;
      while ((line = reader.readLine()) != null)
        lines.add(line);
      return lines;
    } catch (IOException e) {
      throw e;
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
        }
      }
    }
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
