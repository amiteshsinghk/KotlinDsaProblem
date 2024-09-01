package sorting

/*
* Insertion sort is a simple sorting algorithm that works by iteratively inserting each element
* of an unsorted list into its correct position in a sorted portion of the list.
* It is a stable sorting algorithm, meaning that elements with equal values maintain their relative order in the sorted output.
* Insertion Sort Algorithm:
* Insertion sort is a simple sorting algorithm that works by building a sorted array one element at a time.
* It is considered an ” in-place ” sorting algorithm, meaning it doesn’t require any additional memory space beyond the original array.
* To achieve insertion sort, follow these steps:
* We start with second element of the array as first element in the array is assumed to be sorted.
* Compare second element with the first element and check if the second element is smaller then swap them.
* Move to the third element and compare it with the second element, then the first element and swap as necessary to put it in the correct position among the first three elements.
* Continue this process, comparing each element with the ones before it and swapping as needed to place it in the correct position among the sorted elements.
* Repeat until the entire array is sorted.
*
* Ref : https://www.geeksforgeeks.org/insertion-sort-algorithm/
* Ref : https://www.youtube.com/watch?v=PkJIc5tBRUE&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop&index=16
* */
fun main(){
    insertionSort()
}

fun insertionSort(){
    val list = mutableListOf(7,8,3,1,2)
    for(i in 1 until list.size){
        val current = list[i]
        var j = i-1
        while(j>= 0 && current < list[j]){
            list[j+1] = list[j]
            j--
        }
//        here j becomes -1 so j+1 = 0 item insert at the first place.
        list[j+1] = current
    }
    println(list)
}