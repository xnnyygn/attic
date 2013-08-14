package in.xnnyygn.attic;

import java.util.HashMap;
import java.util.Map;

public class DefaultDirectiveContext implements DirectiveContext {

  private final Map<String, Object> variableMap = new HashMap<String, Object>();

  public Object getVariable(String name) {
    return variableMap.get(name);
  }

  public void setVariable(String name, Object value) {
    variableMap.put(name, value);
  }

}
