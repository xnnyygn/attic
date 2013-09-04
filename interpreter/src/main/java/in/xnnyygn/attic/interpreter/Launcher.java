package in.xnnyygn.attic.interpreter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Launcher {

  public static void main(String[] args) throws IOException, ParseException {
    CommandLine line = parse(args);
    List<String> packages = parseCommandPath(line.getOptionValue("CP"));
    Interpreter interpreter = new Interpreter(packages);
    InputStream in = determineInput(line.getArgs());
    String encoding = line.getOptionValue('e', "UTF-8");
    interpreter.interpret(new InputStreamReader(in, encoding));
  }

  private static InputStream determineInput(String[] args) throws FileNotFoundException {
    if (args.length == 0) return System.in;
    return new FileInputStream(args[0]);
  }

  static CommandLine parse(String[] args) throws ParseException {
    CommandLineParser parser = new BasicParser();
    Options options = new Options();
    options.addOption("e", "encoding", true,
        "script encoding, default is UTF-8");
    options.addOption("CP", "commandpath", true,
        "additional command path, separated by colon");
    return parser.parse(options, args);
  }

  static List<String> parseCommandPath(String rawCommandPath) {
    String commandPath = rawCommandPath != null ? rawCommandPath.trim() : "";
    if (commandPath.isEmpty()) return Collections.emptyList();
    return Arrays.asList(commandPath.split(":"));
  }

}
