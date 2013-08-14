package in.xnnyygn.attic;

import in.xnnyygn.attic.parser.ParseException;

import java.io.FileNotFoundException;

public class IntercepreterRunner {

  public static void main(String[] args) throws ParseException,
      FileNotFoundException {
    Interpreter.main(new String[] {"src/test/resources/test.ssv"});
  }

}
