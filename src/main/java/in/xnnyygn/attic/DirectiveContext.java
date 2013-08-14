package in.xnnyygn.attic;

public interface DirectiveContext {

  Object getVariable(String name);
  
  void setVariable(String name, Object value);
  
}
