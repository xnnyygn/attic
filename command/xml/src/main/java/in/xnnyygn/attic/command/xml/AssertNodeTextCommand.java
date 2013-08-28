package in.xnnyygn.attic.command.xml;

import in.xnnyygn.attic.api.Command;
import in.xnnyygn.attic.api.CommandArguments;
import in.xnnyygn.attic.api.CommandContext;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

public class AssertNodeTextCommand implements Command {

  private String variableName;
  private String xpath;
  private String expectedText;

  public void setArguments(CommandArguments arguments) {
    variableName = arguments.get(0);
    xpath = arguments.get(1);
    expectedText = arguments.get(2);
  }

  public void execute(CommandContext context) {
    String xmlText = context.getVariable(variableName);
    Document document = parseXml(xmlText);
    Node node = document.getRootElement().selectSingleNode(xpath);
    if (!expectedText.equals(node.getText())) {
      throw new IllegalStateException("expect [" + expectedText
          + "], but was [" + node.getText() + "]");
    }
  }

  private Document parseXml(String xmlText) {
    try {
      return DocumentHelper.parseText(xmlText);
    } catch (DocumentException e) {
      throw new IllegalArgumentException("failed to parse xml [" + xmlText
          + "] cause is [" + e.getMessage() + "]", e);
    }
  }

}
