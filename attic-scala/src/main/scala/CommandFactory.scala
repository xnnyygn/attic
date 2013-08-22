package in.xnnyygn.attic.commandfactory

import in.xnnyygn.attic.core.{Command, CommandContext, UnaryCommand, NullaryCommand}

class CommandFactory(packages: Traversable[String] = List("in.xnnyygn.attic.command")) {

  class NoSuchCommandException(message: String) extends RuntimeException(message)

  def create(line: String): Command = {
    val args = line.split("\\s").toList
    findCommandClass(packages, args.head) match {
      case Some(clazz) => newInstance(clazz, args.tail).asInstanceOf[Command]
      case _ => throw new NoSuchCommandException("no such command [" + args.head + "]")
    }
  }

  def findCommandClass(packages: Traversable[String], commandName: String): Option[Class[_]] = 
    packages.view.flatMap(pkg => loadClass(pkg + '.' + commandName + "Command")).headOption

  def loadClass(name: String): Option[Class[_]] = try {
    Some(Class.forName(name))
  } catch {
    case _ => None
  }

  def newInstance(clazz: Class[_], args: Traversable[String]): Any = clazz match {
    case cls if classOf[NullaryCommand].isAssignableFrom(cls) => clazz.newInstance
    case cls if classOf[UnaryCommand].isAssignableFrom(cls) => clazz.getConstructor(classOf[String]).newInstance(args.head)
    case _ => clazz.getConstructor(classOf[Traversable[String]]).newInstance(args)
  }

}
