import net.fratech.scala_intro.forJava.{Phase, Projecto}
import net.fratech.scala_intro.Project

val project = new Project

project.asInstanceOf[Any]     // O casting ocorre normalmente
project.asInstanceOf[String]  // ClassCastException

project start new Phase