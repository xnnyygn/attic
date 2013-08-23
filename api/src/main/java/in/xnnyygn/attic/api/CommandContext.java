package in.xnnyygn.attic.api;

public interface CommandContext {

  boolean containsVariable(String key);
  
  <T> T getVariable(String key);

  <T> void setVariable(String key, T value);

  <T> T remove(String key);

}
