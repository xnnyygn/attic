package in.xnnyygn.attic.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DefaultCommandArgumentsTest {
  
  @Test(expected = IllegalArgumentException.class)
  public void testCreateWithEmptyArguments() {
    new DefaultCommandArguments();
  }

  @Test
  public void testGetName() {
    DefaultCommandArguments arguments =
        new DefaultCommandArguments("foo", "1", "2");
    assertEquals("foo", arguments.getName());
  }

  @Test
  public void testGetParameter() {
    DefaultCommandArguments arguments =
        new DefaultCommandArguments("foo", "1", "2");
    assertEquals("1", arguments.getParameter(1));
    assertEquals("2", arguments.getParameter(2));
  }
  
  @Test
  public void testGetParameterWithDefaultValue() {
    DefaultCommandArguments arguments =
        new DefaultCommandArguments("foo", "1", "2");
    assertEquals("1", arguments.getParameter(1));
    assertEquals("2", arguments.getParameter(2));
    assertEquals("3", arguments.getParameter(3, "3"));
  }

  @Test
  public void testGetParameterCount() {
    DefaultCommandArguments arguments =
        new DefaultCommandArguments("foo", "1", "2");
    assertEquals(2, arguments.getParameterCount());
  }

}
