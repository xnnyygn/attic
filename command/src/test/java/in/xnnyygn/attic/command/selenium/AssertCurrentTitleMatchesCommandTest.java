package in.xnnyygn.attic.command.selenium;

import in.xnnyygn.attic.api.Command;
import in.xnnyygn.attic.api.CommandContext;
import in.xnnyygn.attic.api.DefaultCommandArguments;
import in.xnnyygn.attic.api.DefaultCommandContext;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class AssertCurrentTitleMatchesCommandTest {

  private JUnitRuleMockery context;
  private WebDriver mockWebDriver;

  @Before
  public void setUp() throws Exception {
    context = new JUnitRuleMockery();
    mockWebDriver = context.mock(WebDriver.class);
  }

  @Test
  public void testExecute() {
    context.checking(new Expectations() {
      {
        oneOf(mockWebDriver).getTitle();
        will(returnValue("foobar"));
      }
    });
    Command command = new AssertCurrentTitleMatchesCommand();
    command.setArguments(new DefaultCommandArguments("", "^foo.*$"));
    CommandContext cmdCtx = new DefaultCommandContext();
    cmdCtx.setVariable(SeleniumCommandVariables.WEBDRIVER, mockWebDriver);
    command.execute(cmdCtx);
  }

}
