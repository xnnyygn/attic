package in.xnnyygn.attic.directive.factory;

import in.xnnyygn.attic.Command;
import in.xnnyygn.attic.Directive;

import java.util.ArrayList;
import java.util.List;

public class ClassNameDirectiveFactory implements DirectiveFactory {

  public List<Directive> create(List<Command> commands) {
    List<Directive> directives = new ArrayList<Directive>();
    for (Command command : commands) {
      directives.add(create(command));
    }
    return directives;
  }

  @SuppressWarnings("unchecked")
  private Directive create(Command command) throws DirectiveCreateException {
    String className =
        "in.xnnyygn.attic.directives." + command.getName() + "Directive";
    try {
      Class<? extends Directive> clazz =
          (Class<? extends Directive>) Class.forName(className);
      return clazz.getConstructor(Command.class).newInstance(command);
    } catch (Exception e) {
      throw new DirectiveCreateException("failed to create command " + command
          + ", try to load and create new instance of class " + className, e);
    }

  }

}
