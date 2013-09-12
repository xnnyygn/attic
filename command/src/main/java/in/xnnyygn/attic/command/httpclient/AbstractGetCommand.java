package in.xnnyygn.attic.command.httpclient;

import static in.xnnyygn.attic.command.http.HttpCommandConstants.VAR_URI;
import static in.xnnyygn.attic.command.http.HttpCommandUtils.getEncoding;
import static in.xnnyygn.attic.command.http.HttpCommandUtils.getOrCreateHttpParam;
import in.xnnyygn.attic.api.Command;
import in.xnnyygn.attic.api.CommandContext;
import in.xnnyygn.attic.command.http.HttpParams;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

abstract class AbstractGetCommand implements Command {

  static final HttpClient client = new HttpClient();

  public void execute(CommandContext context) {
    GetMethod method = new GetMethod((String) context.getVariable(VAR_URI));
    HttpParams params = getOrCreateHttpParam(context);
    method.setQueryString(params.toQueryString(getEncoding(context)));
    try {
      client.executeMethod(method);
      postGet(context, method);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      method.releaseConnection();
    }
  }

  abstract void postGet(CommandContext context, GetMethod method)
      throws IOException;

}
