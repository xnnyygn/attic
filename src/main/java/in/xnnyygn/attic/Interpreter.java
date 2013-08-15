package in.xnnyygn.attic;

import in.xnnyygn.attic.directive.factory.ClassNameDirectiveFactory;
import in.xnnyygn.attic.directive.factory.DirectiveFactory;
import in.xnnyygn.attic.parser.Parser;
import in.xnnyygn.attic.parser.SpaceSeparatedValueParser;

import java.io.FileInputStream;
import java.io.InputStream;

public class Interpreter {

  public void apply(InputStream in) {
    Parser parser = new SpaceSeparatedValueParser();
    DirectiveFactory directiveFactory = new ClassNameDirectiveFactory();
    DirectiveContext directiveContext = new DefaultDirectiveContext();
    for (Directive directive : directiveFactory.create(parser.apply(in))) {
      directive.execute(directiveContext);
    }
  }

  public static void main(String[] args) throws Exception {
    InputStream in = args.length > 0 ? new FileInputStream(args[0]) : System.in;
    Interpreter interpreter = new Interpreter();
    interpreter.apply(in);
  }

}
