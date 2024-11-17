package linkedListEx

/*You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.



Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.*/

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

// Function to merge two sorted lists
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if(list1 == null && list2 == null) return null
    if(list1 == null && list2 != null) return list2
    if(list1 != null && list2 == null) return list1
    val dummy = ListNode(0) // Dummy node
    var current = dummy

    var s1 = list1
    var s2 = list2

    while (s1 != null && s2 != null) {
        if (s1.`val` <= s2.`val`) {
            current.next = s1
            s1 = s1.next
        } else {
            current.next = s2
            s2 = s2.next
        }
        current = current.next!!
    }

    if (s1 != null) current.next = s1
    if (s2 != null) current.next = s2

    return dummy.next
}

// Helper class for LinkedList
class LinkedLists {
    var head: ListNode? = null

    fun add(value: Int): LinkedLists {
        if (head == null) {
            head = ListNode(value)
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = ListNode(value)
        }
        return this
    }
}

// Main function
fun main() {
    val list1 = LinkedLists()
    list1.add(1).add(5).add(8) // Add elements in correct order

    val list2 = LinkedLists()
    list2.add(1).add(3).add(4) // Add elements in correct order

    val mergedList = mergeTwoLists(list1.head, list2.head)

    // Print the merged list
    var current = mergedList
    while (current != null) {
        print("${current.`val`} ")
        current = current.next
    }
}