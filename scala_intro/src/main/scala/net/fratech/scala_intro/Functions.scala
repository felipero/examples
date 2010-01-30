package net.fratech.scala_intro

/**
 * @author Felipe Rodrigues - felipe (at) fratech.net
 */
class Functions {

  var holdingAFunction = (x: String) => println(x)

  def iTakeAFunctionWithNoParams(b: String)(cls: => String) = {
    println(cls + b)
  }

  def iTakeAFunctionWithParams(b: String, f: String => Any) = {
    f(b)
  }

  def methodWithLocalFunction() = {
    def aFunction(b: String) = {
      println(b)
    }
    aFunction("Message")  // Works
  }

  def callIt = {
    holdingAFunction("running a function literal")
    iTakeAFunctionWithNoParams("a string") { "The closure: " }
    iTakeAFunctionWithParams("a string", b => {println(b); "The closure: "})
    iTakeAFunctionWithParams("a string", println _) 
    methodWithLocalFunction()
//    aFunction("message") // Compilation Error
  }

}