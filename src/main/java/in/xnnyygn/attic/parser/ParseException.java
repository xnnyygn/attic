package in.xnnyygn.attic.parser;

public class ParseException extends RuntimeException {

  private static final long serialVersionUID = -5275271142851811144L;

  public ParseException(String message) {
    super(message);
  }


  public ParseException(String message, Throwable cause) {
    super(message, cause);
  }

}
