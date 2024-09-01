package sorting

/*
Selection sort is a simple and efficient sorting algorithm that works by repeatedly selecting the smallest (or largest)
element from the unsorted portion of the list and moving it to the sorted portion of the list

The algorithm repeatedly selects the smallest (or largest) element from the unsorted portion of
the list and swaps it with the first element of the unsorted part.
This process is repeated for the remaining unsorted portion until the entire list is sorted.


Ref : https://www.geeksforgeeks.org/insertion-sort-algorithm/
Ref : https://www.youtube.com/watch?v=PkJIc5tBRUE&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop&index=16

* */
fun main() {
    selectionSort()
}

fun selectionSort() {
    val list = mutableListOf(8, 5, 7, 6, 1, 9, 2)
    for (i in 0 until list.size) {
        var smallest = i
        for (j in i + 1 until list.size) {
            if (list[smallest] > list[j]) {
                smallest = j
            }
        }
        var temp = list[smallest]
        list[smallest] = list[i]
        list[i] = temp
    }
    println(list)
}