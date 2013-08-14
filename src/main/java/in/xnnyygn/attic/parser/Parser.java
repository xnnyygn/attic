package in.xnnyygn.attic.parser;

import in.xnnyygn.attic.Command;

import java.io.InputStream;
import java.util.List;

public interface Parser {
  
  List<Command> apply(InputStream in) throws ParseException;

}
