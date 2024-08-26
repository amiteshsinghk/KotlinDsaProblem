package linkedListEx

class LinkedList <T>{
    var head : Node<T>? = null
    var tail : Node<T>? = null
    var size = 0
    fun isEmpty() : Boolean{
        return size== 0
    }

    override fun toString(): String {
        return if (isEmpty()) "Empty List"
        else head.toString()
    }

    fun push(value: T): LinkedList<T>{
        head = Node(value, next = head)
        if (tail == null) tail = head
        size += 1
        return this
    }

    fun append(value: T){
        if (tail == null) {
            push(value)
            return
        }
        tail?.next = Node(value= value)
        tail = tail?.next
        size ++
    }

    fun nodeAt(index:Int):Node<T>?{
        var currentNode = head
        var currentIndex = 0
        while (currentNode != null && currentIndex <index){
            currentNode = currentNode.next
            currentIndex++
        }
        println("currentNode $currentNode")
        return  currentNode
    }

    fun insert(value: T,afterNode: Node<T>): Node<T>{
        if (tail == afterNode) {
            append(value)
            return tail!!
        }
        val newNode = Node(value= value, next = afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }

    fun pop():T?{
        if (!isEmpty()) size--
        val result = head?.value
        head = head?.next
        if (isEmpty()) tail =null
            return result

    }

    fun removeLast():T?{
        val head = head ?: return null
        if (head.next == null) pop()
        size--
       var prev = head
       var current = head
        var next = current.next
        while (next != null){
            prev = current
            current = next
            next = current.next
        }
        prev.next = null
        tail = prev
        return current.value
    }

    fun removeAfter(node: Node<T>?):T?{
        val result = node?.next?.value
        if (node?.next == tail) tail = node
        if (node?.next != null) size--
        node?.next = node?.next?.next
        return  result
    }

    fun reverseListIterator(){
        if(head?.next == null || head == null) return
        var previousNode = head
        var currentNode = head?.next
        while (currentNode != null){
            var nextNode = currentNode.next
            currentNode.next = previousNode
            previousNode = currentNode
            currentNode = nextNode
        }
        head?.next = null
        head = previousNode
    }
// https://www.youtube.com/watch?v=t7YaoQOFXzk&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop&index=29

    fun reverseList(){
        if (head == null || head?.next == null) return
        var previousNode = head
        var currentNode = previousNode?.next
        while (currentNode != null){
            var nextNode = currentNode.next
            currentNode.next = previousNode
            previousNode = currentNode
            currentNode = nextNode
        }
        head?.next = null
        head = previousNode
    }

    fun reverseListRecurssion(head : Node<T>?) : Node<T>?{
        if (head == null || head.next == null ) return head
        var newHead = reverseListRecurssion(head.next)
        head?.next?.next = head
        head.next = null
        return newHead

    }

    fun swapLists(heads: Node<T>?): Node<T>?{
        if (heads == null || heads.next == null) return heads
        var dummyNode = Node(0 as T)
        dummyNode.next = heads
        var currentNode : Node<T>?= dummyNode
        while (currentNode?.next != null && currentNode?.next?.next != null){
            var firstItem = currentNode.next
            var secondItem = currentNode?.next?.next
            firstItem?.next = secondItem?.next
            secondItem?.next = firstItem
            currentNode.next = secondItem
            currentNode = firstItem

        }
        return dummyNode.next
    }

    fun swapList(heads : Node<T>?):Node<T>?{
        if(heads == null || heads.next == null) return heads
        val dummyNode  = Node(0 as T)
        dummyNode?.next = heads
        var currentNode : Node<T>?= dummyNode
        while(currentNode?.next != null && currentNode?.next?.next != null){
            val firstItem = currentNode?.next
            val secondItem = currentNode?.next?.next
            firstItem?.next = secondItem?.next
            secondItem?.next = firstItem
            currentNode?.next = secondItem
            currentNode = firstItem
        }
        println("dummyNode :: $dummyNode :: next ${dummyNode?.next}" )
        return dummyNode?.next
    }

    fun swapPairs(head: Node<Int>?): Node<Int>? {
        if(head == null || head.next == null) return head
        val dummyNode : Node<Int>? = Node(0)
        dummyNode?.next = head
        var currentNode = dummyNode
        while(currentNode?.next != null ){
            val firstItem = currentNode?.next
            val secondItem = currentNode?.next?.next
            firstItem?.next = secondItem?.next
            secondItem?.next = firstItem
            currentNode = secondItem
            currentNode = secondItem?.next
        }
        return dummyNode
    }

    fun removeNthFromEnd(head:  Node<T>?, n: Int):  Node<T>? {
        var nodeLength = 0
        var currentNode= head
        while(currentNode != null){
            nodeLength ++
            currentNode= currentNode?.next
        }
        var dummyNode = Node(0 as T)
        dummyNode?.next = head
        currentNode = dummyNode
        for(i in 0 until (nodeLength-n)){
            currentNode = currentNode?.next
        }
        currentNode?.next = currentNode?.next?.next
        return dummyNode?.next
    }

    fun removeNthFromEnds(head:  Node<T>?, n: Int):  Node<T>? {
       if (head== null) return null
        var nodeSize = 0
        var current = head
        while (current != null){
            nodeSize++
            current = current.next
        }
         var itemNode = head
        var preItemIndex = nodeSize- n
        var i=1
        while (i != preItemIndex){
            itemNode = itemNode?.next
            i++
        }
        itemNode?.next = itemNode?.next?.next
        return head
    }




}