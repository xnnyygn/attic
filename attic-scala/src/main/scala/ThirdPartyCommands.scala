package in.xnnyygn.attic.thirdparty.command

import in.xnnyygn.attic.core.{Command, CommandContext, NullaryCommand}

class PrintHelloWorldCommand extends NullaryCommand {
  def execute(context: CommandContext) = println("Hello, world!")
}
