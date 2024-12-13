/*
* As per document suspending function call be from from another suspending function or form a coroutine scope.
* A work around is this where we are passing a suspending function in a non suspending function using inline keyword.
*
* Here, passMeSuspendingFunction can take suspend as well as non suspend function and can do some action.
* */
suspend fun main(){
    println(passMeSuspendingFunction{ printMe() } )
}

inline fun passMeSuspendingFunction(abc:()-> String): String{
    return abc()
}

suspend fun printMe(): String{
//    delay(1000)
    return "Application :: I m suspending function "
}


