package in.xnnyygn.attic.interpreter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;
import org.junit.Test;

public class LauncherTest {

  @Test
  public void testParse() throws ParseException {
    CommandLine line =
        Launcher.parse(new String[] {"-e", "UTF-8", "-CP", "foo.bar"});
    assertEquals("UTF-8", line.getOptionValue('e'));
    assertEquals("foo.bar", line.getOptionValue("CP"));
  }

  @Test
  public void testParseNoCommandPath() throws ParseException {
    CommandLine line = Launcher.parse(new String[] {});
    assertEquals("", line.getOptionValue("CP", ""));
  }
  
  @Test
  public void testParseCommandPathBlank() {
    assertTrue(Launcher.parseCommandPath(null).isEmpty());
    assertTrue(Launcher.parseCommandPath("").isEmpty());
    assertTrue(Launcher.parseCommandPath(" ").isEmpty());
  }
  
  @Test
  public void parseCommandPath() {
    List<String> paths = Launcher.parseCommandPath("foo.a:bar.b:baz.c");
    assertEquals(3, paths.size());
    assertEquals("foo.a", paths.get(0));
    assertEquals("bar.b", paths.get(1));
    assertEquals("baz.c", paths.get(2));
  }

}
