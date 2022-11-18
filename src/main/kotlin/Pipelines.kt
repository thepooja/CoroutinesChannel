import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main() {

runBlocking {
    val numbres = produceNumbers()
    val sqaures = sqaureNumber(numbres)
    for( i in 1..5)
        println(sqaures.receive())
    println("Done!")
    coroutineContext.cancelChildren()
}
}


fun CoroutineScope.produceNumbers() = produce{
    var x = 1
    while(true)
        send(x++)
}

fun CoroutineScope.sqaureNumber(numbers:ReceiveChannel<Int>) = produce {
    for(x in numbers)
        send(x * x)
}