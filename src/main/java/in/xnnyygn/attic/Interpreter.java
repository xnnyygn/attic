package in.xnnyygn.attic;

import in.xnnyygn.attic.directive.factory.ClassNameDirectiveFactory;
import in.xnnyygn.attic.directive.factory.DirectiveFactory;
import in.xnnyygn.attic.parser.ParseException;
import in.xnnyygn.attic.parser.Parser;
import in.xnnyygn.attic.parser.SpaceSeparatedValueParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Interpreter {

  public static void main(String[] args) throws ParseException,
      FileNotFoundException {
    Parser parser = new SpaceSeparatedValueParser();
    DirectiveFactory directiveFactory = new ClassNameDirectiveFactory();
    for (Directive directive : directiveFactory.create(parser
        .apply(retrieveInput(args)))) {
      directive.execute();
    }
  }

  @SuppressWarnings("resource")
  private static InputStream retrieveInput(String[] args)
      throws FileNotFoundException {
    return args.length > 0 ? new FileInputStream(args[0]) : System.in;
  }

}
