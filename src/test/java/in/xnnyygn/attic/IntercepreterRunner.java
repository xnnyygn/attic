package in.xnnyygn.attic;

import java.io.FileInputStream;

public class IntercepreterRunner {

  public static void main(String[] args) throws Exception {
    new Interpreter().apply(new FileInputStream("src/test/resources/test.ssv"));
  }

}
