package in.xnnyygn.attic.interpreter;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Launcher {

  public static void main(String[] args) throws FileNotFoundException,
      IOException {
    new Interpreter().interpret(args[0]);
  }

}
