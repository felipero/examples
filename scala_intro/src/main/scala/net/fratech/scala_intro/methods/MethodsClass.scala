package net.fratech.scala_intro.methods

/**
 * @author Felipe Rodrigues - felipe (at) fratech.net
 */
class MethodsClass {

  def aMethod = { println("I have no parameters")}

  def aSecondMethod = println("I don't have brackets around my body")

  def printAMessage(msg: String) = {
    println(msg)
  }

  def printAndReturn(msg: String): String = {
    println(msg)
    msg
  }

  def aMethodWithInferedReturnType(i: Int) = {
    "The number is: " + i
  }

  private def privateMethod(i: Int) = {
    println("I'm a private method.")
  }

  def javaSimilar() {
    println("I don't have the annoying '=' sign.")
  }

//  Compilation error
//  def likeInJavaWithReturn(): Int {
//    println("I won't compile. :(")
//  }
//
// private String justLikeJava() {
//    println("I won't compile. :(")
// }

}