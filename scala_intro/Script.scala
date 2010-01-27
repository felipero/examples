import net.fratech.scala_intro.forJava.{Project}

val project = new Project("Project 1", List[String]("module 1", "module 2"))

project.asInstanceOf[Any]     // O casting ocorre normalmente
project.asInstanceOf[String]  // ClassCastException