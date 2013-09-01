package in.xnnyygn.attic.command;

import static org.junit.Assert.*;
import in.xnnyygn.attic.api.CommandContext;
import in.xnnyygn.attic.api.DefaultCommandArguments;
import in.xnnyygn.attic.api.DefaultCommandContext;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Before;
import org.junit.Test;

public class EchoVariableCommandTest {

  private EchoVariableCommand command;
  private StringWriter writer;

  @Before
  public void setUp() {
    command = new EchoVariableCommand();
    writer = new StringWriter();
    command.setWriter(new PrintWriter(writer));
  }

  @Test
  public void testExecuteNoSuchVariable() {
    command.setArguments(new DefaultCommandArguments("EchoVariable", "foo"));
    CommandContext context = new DefaultCommandContext();
    command.execute(context);
    assertEquals("null\n", writer.toString());
  }

  @Test
  public void testExecute() {
    command.setArguments(new DefaultCommandArguments("EchoVariable", "foo"));
    CommandContext context = new DefaultCommandContext();
    context.setVariable("foo", "a");
    command.execute(context);
    assertEquals("a\n", writer.toString());
  }
  
}
