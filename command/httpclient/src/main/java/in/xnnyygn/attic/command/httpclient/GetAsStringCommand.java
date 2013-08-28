package in.xnnyygn.attic.command.httpclient;

import static in.xnnyygn.attic.command.http.HttpCommandUtils.getOrCreateHttpParam;
import static in.xnnyygn.attic.command.http.HttpCommandVariables.URI;
import in.xnnyygn.attic.api.Command;
import in.xnnyygn.attic.api.CommandArguments;
import in.xnnyygn.attic.api.CommandContext;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

public class GetAsStringCommand implements Command {

  public static final String RESPONSE_STRING = "httpclient.response.string";
  private static final HttpClient client = new HttpClient();

  public void setArguments(CommandArguments arguments) {
  }

  public void execute(CommandContext context) {
    GetMethod method = new GetMethod((String) context.getVariable(URI));
    method.setQueryString(getOrCreateHttpParam(context).toQueryString());
    try {
      client.executeMethod(method);
      context.setVariable(RESPONSE_STRING, method.getResponseBodyAsString());
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      method.releaseConnection();
    }
  }

}
