package interviewQuestion
/*
Given a list of integer remove any nodes that have values previously occurred in the list and return a
refrence to the head of the list.

For example the following list has a recurrence of the value 3 initially

3,4,3,6
head =3 tail = 6

3 at the position of 2 is redudent So remove the 3 and the linkedList will be
3,4,6

here head = 3 and tail = 6
*/
class SinglyLinkedListNode(var data: Int){
    var next: SinglyLinkedListNode? = null

}
fun main(){
    val i = SinglyLinkedListNode(3)
    i.next = SinglyLinkedListNode(4)
    i.next?.next = SinglyLinkedListNode(3)
    i.next?.next?.next = SinglyLinkedListNode(2)
    i.next?.next?.next?.next = SinglyLinkedListNode(6)
    i.next?.next?.next?.next?.next = SinglyLinkedListNode(1)
    i.next?.next?.next?.next?.next?.next = SinglyLinkedListNode(3)
    i.next?.next?.next?.next?.next?.next?.next = SinglyLinkedListNode(6)
    i.next?.next?.next?.next?.next?.next?.next?.next = SinglyLinkedListNode(4)
    val result = condense(i)
    var current = result
    while (current?.next != null){
        print("${current.data} ")
        current = current.next

    }
}

fun condense(head: SinglyLinkedListNode?): SinglyLinkedListNode?{
        if (head == null) return null
        val mutableListSet = mutableSetOf<Int?>()
        var current = head
        mutableListSet.add(current.data)
        while (current?.next != null){
            if (mutableListSet.contains(current.next?.data)){
                current.next = current.next?.next
            } else {
                mutableListSet.add(current.next?.data)
                current = current.next
            }
        }
        return  head
}
