package in.xnnyygn.attic.api;


import java.util.HashMap;
import java.util.Map;

public class DefaultCommandContext implements CommandContext {

  private final Map<String, Object> variableMap = new HashMap<String, Object>();
  
  public boolean containsVariable(String key) {
    return variableMap.containsKey(key);
  }

  @SuppressWarnings("unchecked")
  public <T> T getVariable(String key) {
    return (T) variableMap.get(key);
  }

  public <T> void setVariable(String key, T value) {
    variableMap.put(key, value);
  }

  @SuppressWarnings("unchecked")
  public <T> T remove(String key) {
    return (T) variableMap.remove(key);
  }

}
