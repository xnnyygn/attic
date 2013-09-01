package in.xnnyygn.attic.interpreter;

import in.xnnyygn.attic.api.CommandContext;
import in.xnnyygn.attic.api.DefaultCommandContext;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

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

  public void interpret(Reader reader) throws IOException {
    CSVReader csvReader = new CSVReader(reader, ' ');
    String[] fields = null;
    CommandContext context = new DefaultCommandContext();
    while ((fields = csvReader.readNext()) != null) {
      commandFactory.create(fields).execute(context);
    }
    csvReader.close();
  }

}
