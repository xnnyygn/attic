package in.xnnyygn.attic.command.httpclient;

import static org.junit.Assert.assertNotNull;
import in.xnnyygn.attic.api.CommandContext;
import in.xnnyygn.attic.api.DefaultCommandContext;
import in.xnnyygn.attic.command.http.HttpCommandUtils;
import in.xnnyygn.attic.command.http.HttpCommandVariables;
import in.xnnyygn.attic.command.http.HttpParams;

import org.junit.Before;
import org.junit.Test;

public class GetAsStringCommandTest {

  private CommandContext context;

  @Before
  public void setUp() {
    context = new DefaultCommandContext();
    context.setVariable(HttpCommandVariables.URI, "http://cn.bing.com/search");
    HttpParams params = HttpCommandUtils.getOrCreateHttpParam(context);
    params.set("q", "foo");
  }

  @Test
  public void testExecute() {
    GetAsStringCommand command = new GetAsStringCommand();
    command.execute(context);
    String response = context.getVariable(GetAsStringCommand.RESPONSE_STRING);
    assertNotNull(response);
  }

}
