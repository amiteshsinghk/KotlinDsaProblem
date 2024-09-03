package queue

class CircularQueue(private val size: Int) {
    private var arr = IntArray(size)
    private var rear = -1
    private var front = -1

    fun isEmpty(): Boolean {
        return rear == -1 && front == -1
    }

    private fun isFull(): Boolean {
        return (rear + 1) % size == front
    }

//    time complexity= O(n)
    fun add(data: Int) {
        if (isFull()) {
            println("Queue is full.")
            return
        }
//    Increment the front for the first element.
        if (front == -1) front = 0
        rear = (rear + 1) % size
        arr[rear] = (data)
    }

//    time complexity= O(n)
    fun remove(): Int {
        if (isEmpty()) {
            println("Queue is empty")
            return -1
        }
        val result = arr[front]
//    for single element
        if (rear == front){
            rear = -1
            front = -1
        } else front = (front + 1) % size
        return result
    }

    fun peek(): Int {
        if (isEmpty()){
            println("Queue is empty")
            return -1
        }
        return arr[front]
    }

}

fun main(){
    val circularQueue = CircularQueue(5)
    circularQueue.add(1)
    circularQueue.add(2)
    circularQueue.add(3)
    circularQueue.add(4)
    circularQueue.add(5)
    circularQueue.remove()
    circularQueue.add(6)
    circularQueue.remove()
    circularQueue.add(7)
    while (!circularQueue.isEmpty()){
        println(circularQueue.peek())
        circularQueue.remove()
    }
}