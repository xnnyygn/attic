package in.xnnyygn.attic.parser;

import in.xnnyygn.attic.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SpaceSeparatedValueParser implements Parser {

  public List<Command> apply(InputStream in) throws ParseException {
    BufferedReader reader = null;
    List<Command> commands = new ArrayList<Command>();
    try {
      reader = new BufferedReader(new InputStreamReader(in));
      String line = null;
      while ((line = reader.readLine()) != null) {
        if (isCommandLine(line)) commands.add(parseLine(line));
      }
    } catch (IOException e) {
      throw new ParseException("failed to parse file", e);
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          // ignore
        }
      }
    }
    return commands;
  }

  private boolean isCommandLine(String line) {
    return isNotBlank(line) && !isCommentLine(line);
  }

  private boolean isNotBlank(String string) {
    return string != null && string.length() != 0
        && string.trim().length() != 0;
  }

  private boolean isCommentLine(String line) {
    return line.trim().startsWith("#");
  }

  private Command parseLine(String line) throws ParseException {
    String[] tokens = line.split("\\s");
    if (tokens.length == 0)
      throw new ParseException("no command name in line [" + line + "]");
    return new Command(tokens[0], listFromSecond(tokens));
  }

  private List<String> listFromSecond(String[] array) {
    if (array.length < 2) return Collections.emptyList();
    return Arrays.asList(array).subList(1, array.length);
  }

}