package in.xnnyygn.attic.command.http;

import in.xnnyygn.attic.api.Command;
import static in.xnnyygn.attic.command.http.HttpCommandConstants.VAR_URL;
import static org.junit.Assert.*;
import in.xnnyygn.attic.api.CommandContext;
import in.xnnyygn.attic.api.DefaultCommandArguments;
import in.xnnyygn.attic.api.DefaultCommandContext;

import org.junit.Test;

public class SetUrlCommandTest {

  @Test
  public void testExecute() {
    Command cmd = new SetUrlCommand();
    String url = "http://www.google.com/search?q=foo";
    cmd.setArguments(new DefaultCommandArguments("", url));
    CommandContext context = new DefaultCommandContext();
    cmd.execute(context);
    assertEquals(url, context.getVariable(VAR_URL));
  }
}
