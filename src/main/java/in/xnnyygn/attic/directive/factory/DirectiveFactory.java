package in.xnnyygn.attic.directive.factory;

import in.xnnyygn.attic.Command;
import in.xnnyygn.attic.Directive;

import java.util.List;

public interface DirectiveFactory {

  List<Directive> create(List<Command> commands);
  
}
