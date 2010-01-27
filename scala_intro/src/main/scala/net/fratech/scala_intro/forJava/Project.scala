package net.fratech.scala_intro.forJava

/**
 * @author Felipe Rodrigues - felipe (at) fratech.net
 */
class Projecto(val name: String, val modulesNames: List[String]) {
  def start = {
    println("Project is started.")
  }

  def runModule(module: () =>  Any) = {
    module()
  }
}
