package in.xnnyygn.attic.command.http;

import static org.junit.Assert.assertEquals;
import in.xnnyygn.attic.api.CommandContext;
import in.xnnyygn.attic.api.DefaultCommandArguments;
import in.xnnyygn.attic.api.DefaultCommandContext;

import org.junit.Test;

public class SetUriCommandTest {

  @Test
  public void testExecute() {
    SetUriCommand command = new SetUriCommand();
    String uri = "http://www.google.com/";
    command.setArguments(new DefaultCommandArguments("SetUri", uri));
    CommandContext context = new DefaultCommandContext();
    command.execute(context);
    assertEquals(uri, context.getVariable(HttpCommandConstants.VAR_URI));
  }

}
