package in.xnnyygn.attic.command.httpclient;

import java.io.IOException;

import in.xnnyygn.attic.api.CommandArguments;
import in.xnnyygn.attic.api.CommandContext;

import org.apache.commons.httpclient.methods.GetMethod;

public class GetAndPrintCommand extends AbstractGetCommand {

  public void setArguments(CommandArguments arguments) {
  }

  @Override
  void postGet(CommandContext context, GetMethod method) throws IOException {
    System.out.println(method.getResponseBodyAsString());
  }

}
