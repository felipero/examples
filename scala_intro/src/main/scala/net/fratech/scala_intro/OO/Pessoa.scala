package net.fratech.scala_intro.OO

/**
 * @author Felipe Rodrigues - felipe (at) fratech.net
 */
class Pessoa private (val age: Int)

object Pessoa {

  def velha = new Pessoa(70)
  def nova = new Pessoa(0)
  def tipoOMatusalem = new Pessoa(970)

}

//val bisavo = Pessoa velha
//
//val sobrinha = Pessoa nova
//
//val hebe = Pessoa tipoOMatusalem