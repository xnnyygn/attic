package in.xnnyygn.attic.interpreter;

import in.xnnyygn.attic.api.CommandContext;
import in.xnnyygn.attic.api.DefaultCommandContext;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import au.com.bytecode.opencsv.CSVReader;

public class Interpreter {

  private final DefaultCommandFactory commandFactory;

  public Interpreter() {
    this(new ArrayList<String>(0));
  }

  public Interpreter(String additional) {
    this(Arrays.asList(additional));
  }

  public Interpreter(Collection<String> additional) {
    commandFactory = new DefaultCommandFactory(determinePackages(additional));
  }

  static Collection<String> determinePackages(Collection<String> additional) {
    Set<String> pkgs = new HashSet<String>();
    pkgs.add("in.xnnyygn.attic.command");
    pkgs.addAll(additional);
    return pkgs;
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
