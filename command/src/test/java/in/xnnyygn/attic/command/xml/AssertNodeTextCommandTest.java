package in.xnnyygn.attic.command.xml;

import in.xnnyygn.attic.api.CommandContext;
import in.xnnyygn.attic.api.DefaultCommandArguments;
import in.xnnyygn.attic.api.DefaultCommandContext;

import org.junit.Test;

public class AssertNodeTextCommandTest {

  @Test
  public void testExecute() {
    AssertNodeTextCommand command = new AssertNodeTextCommand();
    command.setArguments(new DefaultCommandArguments("AssertNodeText", "xml",
        "/users/user/name", "xnnyygn"));
    CommandContext context = new DefaultCommandContext();
    context.setVariable("xml",
        "<users><user><name>xnnyygn</name></user></users>");
    command.execute(context);
  }

  @Test(expected = IllegalStateException.class)
  public void testExecuteFail() {
    AssertNodeTextCommand command = new AssertNodeTextCommand();
    command.setArguments(new DefaultCommandArguments("AssertNodeText", "xml",
        "/users/user/name", "xy"));
    CommandContext context = new DefaultCommandContext();
    context.setVariable("xml",
        "<users><user><name>xnnyygn</name></user></users>");
    command.execute(context);
  }

}
