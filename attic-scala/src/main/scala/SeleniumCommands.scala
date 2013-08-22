package in.xnnyygn.attic.command.selenium

import in.xnnyygn.attic.core.{Command, CommandContext, NullaryCommand}
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.WebDriver
import in.xnnyygn.attic.command.http.{Http, HttpParams}

object Selenium {
  final val WEB_DRIVER = "selenium.webdriver"
}

class OpenCommand extends NullaryCommand {
  def execute(context: CommandContext) = context.getOrUpdateVariable[WebDriver](Selenium.WEB_DRIVER, new FirefoxDriver).get(
    context.getVariable[String](Http.URI).getOrElse("")  + '?' + context.getVariable[HttpParams](Http.PARAMS).map(_.toQueryString).getOrElse("")
  )
}

class CloseCommand extends NullaryCommand {
  def execute(context: CommandContext) = context.removeVariable[WebDriver](Selenium.WEB_DRIVER).foreach(_.close)
}
