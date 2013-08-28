package in.xnnyygn.attic.command.http;

import static in.xnnyygn.attic.command.http.HttpCommandVariables.PARAMS;
import in.xnnyygn.attic.api.CommandContext;

public class HttpCommandUtils {
  
  public static HttpParams getOrCreateHttpParam(CommandContext context) {
    if (!context.containsVariable(PARAMS))
      context.setVariable(PARAMS, new HttpParams());
    return context.getVariable(PARAMS);
  }
  
}