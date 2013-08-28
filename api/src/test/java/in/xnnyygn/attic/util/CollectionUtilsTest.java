package in.xnnyygn.attic.util;

import static in.xnnyygn.attic.util.CollectionUtils.tail;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CollectionUtilsTest {

  @Test
  public void testTail() {
    assertEquals(asList(), tail(asList("foo")));
    assertEquals(asList("bar"), tail(asList("foo", "bar")));
    assertEquals(asList("bar", "baz"), tail(asList("foo", "bar", "baz")));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTailNull() {
    tail(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTailNil() {
    tail(asList());
  }

}
