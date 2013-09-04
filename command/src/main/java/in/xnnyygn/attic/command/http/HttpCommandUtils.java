package in.xnnyygn.attic.command.http;

import static in.xnnyygn.attic.command.http.HttpCommandConstants.DEFAULT_ENCODING;
import static in.xnnyygn.attic.command.http.HttpCommandConstants.VAR_ENCODING;
import static in.xnnyygn.attic.command.http.HttpCommandConstants.VAR_PARAMS;
import in.xnnyygn.attic.api.CommandContext;

public class HttpCommandUtils {

  public static HttpParams getOrCreateHttpParam(CommandContext context) {
    if (!context.containsVariable(VAR_PARAMS))
      context.setVariable(VAR_PARAMS, new HttpParams());
    return context.getVariable(VAR_PARAMS);
  }

  public static String getEncoding(CommandContext context) {
    String encoding = context.getVariable(VAR_ENCODING);
    return encoding != null ? encoding : DEFAULT_ENCODING;
  }

}
