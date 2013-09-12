package in.xnnyygn.attic.command.selenium;

import static in.xnnyygn.attic.command.selenium.SeleniumCommandVariables.WEBDRIVER;
import in.xnnyygn.attic.api.Command;
import in.xnnyygn.attic.api.CommandArguments;
import in.xnnyygn.attic.api.CommandContext;

import java.io.FileOutputStream;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class TakeScreenShotCommand implements Command {

  private String screenshotPath;

  public void setArguments(CommandArguments arguments) {
    screenshotPath = arguments.getParameter(1);
  }

  public void execute(CommandContext context) {
    WebDriver driver = context.getVariable(WEBDRIVER);
    if (!(driver instanceof TakesScreenshot)) {
      throw new IllegalStateException(
          "current web driver not support screenshot");
    }
    try {
      IOUtils.write(
          ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES),
          new FileOutputStream(screenshotPath));
    } catch (Exception e) {
      throw new IllegalStateException("failed to take screenshot", e);
    }
  }

}
