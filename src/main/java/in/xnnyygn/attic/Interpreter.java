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
    InputStream in = new FileInputStream(args[0]);
    for (Directive directive : directiveFactory.create(parser.apply(in))) {
      directive.execute();
    }
  }

}
