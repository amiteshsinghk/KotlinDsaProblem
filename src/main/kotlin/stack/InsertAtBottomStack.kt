package stack

import java.util.*
/* insert an integer at the bottom of a stack
*  Input : [1, 2, 3]
*  output : [5, 1, 2, 3]
* */
fun main(){
    var stack :Stack<Int>? = Stack()
    stack?.push(1)
    stack?.push(2)
    stack?.push(3)

    println(stack)
    insertAtBottom(stack, 5)
    println(stack)

}

fun insertAtBottom(s:Stack<Int>?, data: Int){
    if (s?.isEmpty() == true){
        s.push(data)
        return
    }
    var top =s?.pop()
    insertAtBottom(s,data)
    s?.push(top)

}

