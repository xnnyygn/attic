package in.xnnyygn.attic.core

import scala.collection.mutable

class CommandContext {
  private val variables = mutable.Map[String, Any]()
  def getVariable[A](key: String): Option[A] = variables.get(key).map(_.asInstanceOf[A])
  def setVariable[A](key: String, value: => A): Unit = variables.put(key, value)
  def getOrUpdateVariable[A](key: String, value: => A): A = variables.getOrElseUpdate(key, value).asInstanceOf[A]
  def removeVariable[A](key: String): Option[A] = variables.remove(key).map(_.asInstanceOf[A])
}

trait Command {
  def execute(context: CommandContext): Unit
}

trait UnaryCommand extends Command

trait NullaryCommand extends Command
