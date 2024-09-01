package sorting
/*Bubble sorting compare the adjecent element and swape the element
1. traverse from left and compare adjacent elements and the higher one is placed at right side.
2. In this way, the largest element is moved to the rightmost end at first.
3. This process is then continued to find the second largest and place it and so on until the data is sorted.
time complexity = o((n^2}

Ref : https://www.geeksforgeeks.org/insertion-sort-algorithm/
Ref : https://www.youtube.com/watch?v=PkJIc5tBRUE&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop&index=16
*/
fun main() {
    bubbleSort()
}

fun bubbleSort() {
    val list = mutableListOf(5, 9, 2, 8, 4, 6)
    for (i in 0 until list.size) {
        for (j in 0 until (list.size - i - 1)) {
            if (list[j] > list[j + 1]) {
                val temp = list[j]
                list[j] = list[j + 1]
                list[j + 1] = temp
            }
            println("List :: $list")
        }
    }
    println(list)
}