package in.xnnyygn.attic.interpreter;

public class NoSuchCommandException extends RuntimeException {

  private static final long serialVersionUID = -208507305037990950L;
  
  public NoSuchCommandException(String message) {
    super(message);
  }

  public NoSuchCommandException(String message, Throwable cause) {
    super(message, cause);
  }

}
