package in.xnnyygn.attic.interpreter;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class InterpreterTest {

  @Test
  public void testReadLines() throws IOException {
    Interpreter interpreter = new Interpreter();
    String text = "foo\nbar";
    ByteArrayInputStream in = new ByteArrayInputStream(text.getBytes());
    List<String> lines = interpreter.readLines(in);
    assertEquals(2, lines.size());
    assertEquals("foo", lines.get(0));
    assertEquals("bar", lines.get(1));
  }

}
