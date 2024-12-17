import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

/*
* create  two function so that one function will print oddNumber and the other function will print even Number.
*
* */

suspend fun oddNumber(maxNumber: Int, channel: Channel<Int>){
    for (i in 1..maxNumber step 2){
        println(i)
        channel.send(i)
        channel.receive()
    }
}

suspend fun evenNumber(maxNumber: Int, channel: Channel<Int>){
    for(i in 2..maxNumber step  2){
        channel.receive()
        println(i)
        channel.send(i)
    }
}

 suspend fun main(){
    var channel = Channel<Int>()
    var maxNumber = 100
        var job1 = CoroutineScope(Dispatchers.IO).launch{ oddNumber(maxNumber, channel) }
        var job2 = CoroutineScope(Dispatchers.IO).launch{ evenNumber(maxNumber, channel) }
        job1.join()
        job2.join()
        channel.close()
}