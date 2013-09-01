package in.xnnyygn.attic.interpreter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Launcher {

  public static void main(String[] args) throws IOException {
    Interpreter interpreter = new Interpreter();
    InputStream in = args.length > 0 ? new FileInputStream(args[0]) : System.in;
    interpreter.interpret(new BufferedReader(new InputStreamReader(in)));
  }

}
