package in.xnnyygn.attic.command.selenium;

import in.xnnyygn.attic.api.Command;
import in.xnnyygn.attic.api.DefaultCommandArguments;
import in.xnnyygn.attic.api.DefaultCommandContext;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class AssertCurrentUrlMatchesTest {

  private JUnitRuleMockery context;
  private WebDriver mockWebDriver;

  @Before
  public void setUp() throws Exception {
    context = new JUnitRuleMockery();
    mockWebDriver = context.mock(WebDriver.class);
  }

  @Test
  public void testExecute() {
    Command cmd = new AssertCurrentUrlMatchesCommand();
    cmd.setArguments(new DefaultCommandArguments("",
        "^http://www.google.com/.*$"));
    context.checking(new Expectations() {
      {
        oneOf(mockWebDriver).getCurrentUrl();
        will(returnValue("http://www.google.com/search?q=foo&a=b&c=d"));
      }
    });
    DefaultCommandContext cmdContext = new DefaultCommandContext();
    cmdContext.setVariable(SeleniumCommandVariables.WEBDRIVER, mockWebDriver);
    cmd.execute(cmdContext);
  }

}
