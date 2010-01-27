import scala.actors.Actor._

var startTime : Long = 0
val script = self
val engrossedActor = actor {

  println("Number of messages received so far? " + mailboxSize)

  script ! "send" // Envia a mensagem

  Thread.sleep(3000) // Processa alguma coisa

  println("Number of messages received while I was busy? " + mailboxSize)

  receive {
    case msg =>
      val receivedTime = System.currentTimeMillis() - startTime
    println("Received message " + msg + " after " + receivedTime + " ms" )
  }

  script ! "received"
}

receive { case _ => }

println("Sending Message " )

startTime = System.currentTimeMillis()

engrossedActor ! "hello buddy"

val endTime = System.currentTimeMillis() - startTime

printf("Took less than %dms to send message\n" , endTime)

receive {
  case _ =>
}

