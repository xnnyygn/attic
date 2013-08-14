package in.xnnyygn.attic.parser;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import in.xnnyygn.attic.Command;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

public class SpaceSeparatedValueParserTest {

  @Test
  public void testApply() {
    SpaceSeparatedValueParser parser = new SpaceSeparatedValueParser();
    StringBuilder linesBuilder = new StringBuilder();
    linesBuilder.append("#first attic script\n");
    linesBuilder.append("\n");
    linesBuilder.append("foo 1 2\n");
    linesBuilder.append("bar 3 4\n");
    byte[] linesBytes = linesBuilder.toString().getBytes();
    InputStream in = new ByteArrayInputStream(linesBytes);
    List<Command> commands = parser.apply(in);
    assertEquals(2, commands.size());
    Command firstCommand = commands.get(0);
    assertEquals("foo", firstCommand.getName());
    assertArrayEquals(new Object[]{"1", "2"}, firstCommand.getArguments().toArray());
  }

}
