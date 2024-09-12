package linkedListEx

/**
 * Source :: https://www.kodeco.com/books/data-structures-algorithms-in-kotlin/v1.0/chapters/3-linked-list
 * https://www.youtube.com/watch?v=oAja8-Ulz6o
 * */


fun main() {
    /*        val node1 = Node(1)
            val node2 = Node(2)
            val node3 = Node(3)
            node1.next= node2
            node2.next = node3

            println("Added data in Node:: $node1")
            val list = LinkedList<Int>()
        val list1 = LinkedList<Int>()
            list.push(3)
            list.push(2)
            list.push(1)
        list1.push(3).push(2).push(1)

            println("Linked List :: $list")
        println("Linked List with return :: $list1")

        list1.append(4)
        println("Linked List with append :: $list1")
        var item = list1.nodeAt(1)!!
        println("Linked List with item :: $item")
        list1.insert(6, item)
        println("Linked List with insert :: $list1")
    //  remove a node using pop
        val poppedValue = list1.pop()
        println("Linked List with pop :: $list1")
        println("Linked List poppedValue :: $poppedValue")
        // remove last
        println("Linked List Before remove last :: $list1")
        val removeLast = list1.removeLast()
        println("Linked List  remove last :: $list1")
        println("Linked  removed last value :: $removeLast")

        // removeAt
        println("Linked  list1 before remove :: $list1")
        val nodeAt = list1.nodeAt(1)
        val removeAt = list1.removeAfter(nodeAt)
        println("Linked List  nodeAt :: $nodeAt")
        println("Linked  removeAfter :: $removeAt")
        println("Linked  list1 :: $list1")


        println("Linked  list before  reverseListIterator :: $list")
        list.reverseList()
        println("Linked  list After  reverseListIterator :: $list")
        list.head =list.reverseListRecurssion(list.head)
        println("Linked  list After  reverseListRecurssion :: $list")*/

    /*
    * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
    * */
    val swapList = LinkedList<Int>()
    swapList.push(5).push(4).push(3).push(2).push(1)
    val l1 = swapList.swapList(swapList.head)
    println("Swape List :: $l1")


    /*
* Remove nth item from end
* */

    val removeItemList = LinkedList<Int>()
    removeItemList.push(5).push(4).push(3).push(2).push(1)
    val afterRemove = removeItemList.removeNthFromEnd(removeItemList.head, 2)
    println(" List after remove nth item from end :: $afterRemove")

}
