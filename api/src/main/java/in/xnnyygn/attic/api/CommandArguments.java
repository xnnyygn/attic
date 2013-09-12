package in.xnnyygn.attic.api;

public interface CommandArguments {
  
  String getName();
  
  String getParameter(int index);
  
  String getParameter(int index, String defaultValue);
  
  int getParameterCount();
  
}