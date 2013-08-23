package in.xnnyygn.attic.interpreter;

import static org.apache.commons.io.IOUtils.readLines;
import in.xnnyygn.attic.api.CommandContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Launcher {

  public static void main(String[] args) throws FileNotFoundException,
      IOException {
    DefaultCommandFactory commandFactory = new DefaultCommandFactory();
    CommandContext context = new DefaultCommandContext();
    for (String line : readLines(new FileInputStream(args[0]))) {
      commandFactory.create(line).execute(context);
    }
  }

}
