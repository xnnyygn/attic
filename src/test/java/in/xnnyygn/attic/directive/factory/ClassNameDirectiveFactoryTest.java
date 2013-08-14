package in.xnnyygn.attic.directive.factory;

import static org.junit.Assert.assertEquals;
import in.xnnyygn.attic.Command;
import in.xnnyygn.attic.Directive;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ClassNameDirectiveFactoryTest {

  @Test
  public void testCreate() {
    ClassNameDirectiveFactory factory = new ClassNameDirectiveFactory();
    Command echoCommand = new Command("Echo", Arrays.asList("Hi!"));
    List<Directive> directives = factory.create(Arrays.asList(echoCommand));
    assertEquals(1, directives.size());
  }

}
