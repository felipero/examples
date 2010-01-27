import scala.actors._
import Actor._

val fortuneTeller = actor {
  for (i <- 1 to 4) {
    Thread.sleep(1000)
    receive {
      case _ => sender ! "your day will rock! " + i
      //case _ => reply("your day will rock! " + i) // same as above
      }
    }
}

println( fortuneTeller !? (2000, "what's ahead" ) )
println( fortuneTeller !? (500, "what's ahead" ) )

val aPrinter = actor {
  receive { case msg => println("Ah, fortune message for you-" + msg) }
}

fortuneTeller.send("What's up" , aPrinter)
fortuneTeller ! "How's my future?"
Thread.sleep(3000)

receive { case msg : String => println("Received " + msg ) }

println("Let's get that lost message" )

receive { case !(channel, msg) => println("Received belated message " + msg) }
