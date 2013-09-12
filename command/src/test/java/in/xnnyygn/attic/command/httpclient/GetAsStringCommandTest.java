package in.xnnyygn.attic.command.httpclient;

import static org.junit.Assert.*;
import in.xnnyygn.attic.api.DefaultCommandArguments;

import org.junit.Test;

public class GetAsStringCommandTest {

  @Test
  public void testSetArgumentsUseDefault() {
    GetAsStringCommand cmd = new GetAsStringCommand();
    cmd.setArguments(new DefaultCommandArguments(""));
    assertEquals(GetAsStringCommand.DEFAULT_RESPONSE_VARIABLE_NAME,
        cmd.getResponseVariableName());
  }

  @Test
  public void testSetArguments() {
    GetAsStringCommand cmd = new GetAsStringCommand();
    cmd.setArguments(new DefaultCommandArguments("", "foo"));
    assertEquals("foo", cmd.getResponseVariableName());
  }

}
