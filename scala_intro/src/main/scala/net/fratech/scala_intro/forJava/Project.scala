package net.fratech.scala_intro.forJava

/**
 * @author Felipe Rodrigues - felipe (at) fratech.net
 */
class Projecto(val name: String, val modulesNames: List[String]) {

  var subprojects: List[Projecto] = List[Projecto]()
  
  def start = {
    println("Project is started.")
  }

  def +(p: Projecto) {
    subprojects = subprojects + p
  }

  def runModule(module: () =>  Any) = {
    module()
  }
}
