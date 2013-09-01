package in.xnnyygn.attic.command;

import static org.junit.Assert.assertEquals;
import in.xnnyygn.attic.api.DefaultCommandArguments;
import in.xnnyygn.attic.api.DefaultCommandContext;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Test;

public class PrintlnCommandTest {

  @Test
  public void testExecute() {
    PrintlnCommand command = new PrintlnCommand();
    command.setArguments(new DefaultCommandArguments("Println", "Hello, world!"));
    StringWriter writer = new StringWriter();
    command.setWriter(new PrintWriter(writer));
    command.execute(new DefaultCommandContext());
    assertEquals("Hello, world!\n", writer.toString());
  }

}
