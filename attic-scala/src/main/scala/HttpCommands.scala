package in.xnnyygn.attic.command.http

import scala.collection.mutable
import in.xnnyygn.attic.core.{Command, CommandContext, UnaryCommand}

object Http {
  final val URI = "http.uri"
  final val PARAMS = "http.params"
}

class SetUriCommand(uri: String) extends UnaryCommand {
  def execute(context: CommandContext) = context.setVariable(Http.URI, uri)
}

class SetParamCommand(name: String, value: String) extends Command {
  def this(args: Traversable[String]) = this(args.head, args.tail.head)
  def execute(context: CommandContext) = context.getOrUpdateVariable(Http.PARAMS, new DefaultHttpParams).setParam(name, value)
}

trait HttpParams {
  def setParam(name: String, value: String): Unit
  def getParam(name: String): Option[List[String]]
  def toQueryString(): String
}

object NoneHttpParams extends HttpParams {
  def setParam(name: String, value: String) = ()
  def getParam(name: String) = None
  def toQueryString = ""
}

class DefaultHttpParams extends HttpParams {
  private val params = mutable.Map[String, List[String]]()
  def setParam(name: String, value: String) = params.put(name, List(value))
  def getParam(name: String) = params.get(name)
  def toQueryString = params.flatMap{pair => 
    val k = pair._1
    pair._2.map(v => k + '=' + v)
  }.mkString("&")
}

class EchoParamCommand(name: String) extends UnaryCommand {
  def execute(context: CommandContext) = println(context.getVariable[HttpParams](Http.PARAMS).getOrElse(NoneHttpParams).getParam(name))
}
