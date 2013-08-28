package in.xnnyygn.attic.command.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import org.junit.Test;

public class HttpParamsTest {

  @Test
  public void testSet() {
    HttpParams params = new HttpParams();
    params.set("foo", "a");
    assertEquals("a", params.getValue("foo"));
  }

  @Test
  public void testSetMultipleValue() {
    HttpParams params = new HttpParams();
    params.set("foo", "a");
    params.set("foo", "b");
    List<String> values = params.getValues("foo");
    assertEquals(1, values.size());
    assertEquals("b", values.get(0));
  }

  @Test
  public void testGetNames() {
    HttpParams params = new HttpParams();
    params.set("foo", "a");
    params.set("bar", "b");
    Set<String> names = params.getNames();
    assertTrue(names.contains("foo"));
    assertTrue(names.contains("bar"));
  }

  @Test
  public void testToQueryString() {
    HttpParams params = new HttpParams();
    params.set("foo", "a");
    assertEquals("foo=a", params.toQueryString());
  }

}
