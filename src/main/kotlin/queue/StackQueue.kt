package queue

import java.util.*

class StackQueue(){
    var s1 = Stack<Int>()
    var s2 = Stack<Int>()
    fun isEmpty(): Boolean{
        return s1.isEmpty()
    }

    fun add(data :Int){
        while (!s1.isEmpty()){
            s2.push(s1.pop())
        }
        s1.push(data)
        while (!s2.isEmpty()){
            s1.push(s2.pop())
        }
    }

    fun remove():Int{
        if (isEmpty()){
            println("Queue is empty")
            return -1
        }
        val topItem = s1.peek()
        s1.pop()
        return topItem
    }

    fun peek(): Int{
        if (isEmpty()){
            println("Queue is empty")
            return -1
        }
        return s1.peek()
    }
}

fun main(){
    val stackQueue = StackQueue()
    stackQueue.add(1)
    stackQueue.add(2)
    stackQueue.add(3)
    stackQueue.add(4)
    stackQueue.add(5)
    stackQueue.add(6)

    while (!stackQueue.isEmpty()){
        println(stackQueue.peek())
        stackQueue.remove()
    }

}

