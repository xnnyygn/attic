package in.xnnyygn.attic.command.http;

import static org.junit.Assert.assertEquals;
import in.xnnyygn.attic.api.CommandContext;
import in.xnnyygn.attic.api.DefaultCommandArguments;
import in.xnnyygn.attic.api.DefaultCommandContext;

import org.junit.Test;

public class SetParamCommandTest {

  @Test
  public void testExecute() {
    SetParamCommand command = new SetParamCommand();
    command.setArguments(new DefaultCommandArguments("SetParam", "foo", "b"));
    HttpParams params = new HttpParams();
    params.set("foo", "a");
    CommandContext context = new DefaultCommandContext();
    context.setVariable(HttpCommandConstants.VAR_PARAMS, params);
    command.execute(context);
    assertEquals("b", params.getValue("foo"));
  }

}
