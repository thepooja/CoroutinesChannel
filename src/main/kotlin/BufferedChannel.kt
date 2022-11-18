import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {

        val channel = Channel<Int>(4)
        val sender = launch {
            repeat(10){
                channel.send(it)
                println("sent $it")
            }
        }

        repeat(3){
            delay(3000)
            println("received ${channel.receive()}")
        }
        sender.cancel()
    }
}

