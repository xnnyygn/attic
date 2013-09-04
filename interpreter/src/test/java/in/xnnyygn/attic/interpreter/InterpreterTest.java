package in.xnnyygn.attic.interpreter;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

public class InterpreterTest {

  @Test
  public void testDeterminePackages() {
    Collection<String> packages =
        Interpreter
            .determinePackages(Arrays.asList("in.xnnyygn.attic.command"));
    assertEquals(1, packages.size());
    assertEquals("in.xnnyygn.attic.command", packages.iterator().next());
  }

}
