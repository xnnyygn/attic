package in.xnnyygn.attic

import scala.io.Source
import java.io.File
import in.xnnyygn.attic.core.{Command, CommandContext}
import in.xnnyygn.attic.commandfactory.CommandFactory

object AtticLaucher {
  def main(args: Array[String]): Unit = {
    val context = new CommandContext
    val commandfactory = new CommandFactory(List(
      "in.xnnyygn.attic.command",
      "in.xnnyygn.attic.thirdparty.command"
    ))
    Source.fromFile(new File(args(0))).getLines.map(commandfactory.create).foreach(_.execute(context))
  }
}
