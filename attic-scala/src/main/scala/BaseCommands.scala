package in.xnnyygn.attic.command

import in.xnnyygn.attic.core.{Command, CommandContext, UnaryCommand}

class PrintlnCommand(text: String) extends UnaryCommand {
  def execute(context: CommandContext) = println(text)
}

class PauseCommand(millis: Long) extends Command {
  def this(args: Traversable[String]) = this(args.head.toLong)
  def execute(context: CommandContext) = Thread.sleep(millis)
}

class EchoVariableCommand(name: String) extends UnaryCommand {
  def execute(context: CommandContext) = println(context.getVariable(name))
}
