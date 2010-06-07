package net.fratech.scala_intro.OO

/**
 * @author Felipe Rodrigues - felipe (at) fratech.net
 */
class A extends B with C


abstract class B {
  def aMethod
  def aConcreteMethod = {
    println("A concrete method on class B")
  }
}

trait C {
  def aMethod = {
    println("I did it.")
  }

  def anotherConcreteMethod = {
    println("A concrete method on class C")
  }
}