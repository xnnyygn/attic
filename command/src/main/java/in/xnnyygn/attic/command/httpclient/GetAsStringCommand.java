package in.xnnyygn.attic.command.httpclient;

import in.xnnyygn.attic.api.CommandArguments;
import in.xnnyygn.attic.api.CommandContext;

import java.io.IOException;

import org.apache.commons.httpclient.methods.GetMethod;

public class GetAsStringCommand extends AbstractGetCommand {

  static final String DEFAULT_RESPONSE_VARIABLE_NAME =
      "httpclient.response.string";
  private String responseVariableName;

  public void setArguments(CommandArguments arguments) {
    responseVariableName =
        arguments.getParameter(1, DEFAULT_RESPONSE_VARIABLE_NAME);
  }

  String getResponseVariableName() {
    return responseVariableName;
  }

  @Override
  void postGet(CommandContext context, GetMethod method) throws IOException {
    context.setVariable(responseVariableName, method.getResponseBodyAsString());
  }

}
