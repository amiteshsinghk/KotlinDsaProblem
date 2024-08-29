package stack

import java.util.*

/*
* Reverse a stack
* Input : [1, 2, 3]
* Output : [3, 2, 1]
* */

fun main(){
    var s : Stack<Int> = Stack()
    var t  = arrayListOf<Int>()
    s?.push(1)
    s?.push(2)
    s?.push(3)
    println("Before Reverse :: $s")
    reverseStack(s)
    println("After Reverse :: $s")
}

fun reverseStack(s: Stack<Int>){
    if (s.isEmpty()) return
    val top = s.pop()
    reverseStack(s)
    pushAtBottom(s, top)
}

fun pushAtBottom(s: Stack<Int>, data : Int){
    if (s.isEmpty()){
        s.push(data)
        return
    }
    var top = s.pop()
    pushAtBottom(s,data)
    s.push(top)
}