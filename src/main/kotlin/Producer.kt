import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {

        // basic
       /* val channel = produce {
            for (x in 1..5)
                send(x * x)
        }

        for( y in channel)
            println(y)

        */
        // using function
        for( y in produceSqaures())
            println(y)

        // using consumeeach
        produceSqaures().consumeEach { println(it) }

    }
}


fun CoroutineScope.produceSqaures() = produce {
    for (x in 1..5)
        send(x * x)
}