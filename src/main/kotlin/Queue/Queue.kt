package Queue

class Queue(private var size: Int) {
    private var arr = ArrayList<Int>(size)
    private var rear = -1

    fun isEmpty(): Boolean {
        return rear == -1
    }

    //    Data is added at the end. If the queue is empty, then first and rear both are same.
    //  Time complexity = O(1)
    fun add(data: Int) {
        if (rear == size - 1) {
            println("Array is full we cannot add more data")
            return
        }
        rear++
        arr.add(data)
    }

    //    It will remove the item from the front.
    //    Time complexity =O(n)
    fun remove(): Int {
        if (isEmpty()) {
            println("Queue is empty")
            return -1
        }
        val front = arr[0]
        for (i in 0 until rear) {
            arr[i] = arr[i + 1]
        }
        rear--
        return front
    }
    //    It will return the first item from the front.
    //    Time complexity =O(n)
    fun peek(): Int{
        if (isEmpty()){
            println("Queue is empty.")
            return -1
        }
        return arr[0]
    }

}

fun main(){
    val queue = Queue(5)
    queue.add(1)
    queue.add(2)
    queue.add(3)
    queue.add(4)

    while (!queue.isEmpty()){
        println(queue.peek())
        queue.remove()
    }
}