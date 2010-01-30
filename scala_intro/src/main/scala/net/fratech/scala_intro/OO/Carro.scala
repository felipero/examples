package net.fratech.scala_intro.OO

/**
 * @author Felipe Rodrigues - felipe (at) fratech.net
 */
class Carro(val ano: Int, nome: String, var dono: String) extends Veiculo {
  val modelo = nome + " - " + ano

  def mover() = println("girando a roda para a frente")

}

object MeuCarro {
  private val meuCarro = new Carro(2010, "Audi A3", "Felipe")

  def iniciar = meuCarro.iniciar
  def mover = meuCarro.mover
   
}

//MeuCarro.iniciar
//MeuCarro mover
//val c = MeuCarro
//c iniciar
//c mover

trait Veiculo {
  def iniciar = {
    println("Veículo ligado")
  }

  def mover
}

//val cr = new Carro(2010, "Fusca", "Juca")
//cr.iniciar
//cr.mover
//
//class A extends B with C
//
//abstract class B
//
//trait C
//
//new B with C