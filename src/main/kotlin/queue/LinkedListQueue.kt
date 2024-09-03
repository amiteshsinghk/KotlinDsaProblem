package queue

data class NodeQueue(var data: Int?, var next: NodeQueue? = null)
class LinkedListQueue {
    var head: NodeQueue? = null
    var tail: NodeQueue? = null

    fun isEmpty(): Boolean {
        return head == null && tail == null
    }

    fun add(data: Int) {
        val newNode = NodeQueue(data = data)
        if (isEmpty()) {
            head = newNode
            tail = newNode
        }
        tail?.next = newNode
        tail = newNode
    }

    //    It will remove the item from front.
    fun remove(): Int? {
        if (isEmpty()) {
            println("Queue is empty")
            return -1
        }
        val firstItem = head?.data
        if (head == tail) {
            tail = null
        }
        head = head?.next
        return firstItem
    }

    fun peek(): Int?{
        if (isEmpty()) {
            println("Queue is empty")
            return -1
        }
        return head?.data
    }

}
fun main(){
    val q = LinkedListQueue()
    q.add(1)
    q.add(2)
    q.add(3)
    q.add(4)
    q.add(5)
    q.remove()
    q.add(6)
    q.remove()
    q.add(7)
    while(!q.isEmpty()) {
        System.out.println(q.peek());
        q.remove();
    }

}

