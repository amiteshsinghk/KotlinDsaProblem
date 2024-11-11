package interviewQuestion.amazon

/*
*
An Amazon Fulfillment Associate has a set of items that need to be packed into two boxes.
* Given an integer array of the item weights(arr) to be packed, divide the item weights
* into two subsets, A and B, for packing into the associated boxes, while respecting the following conditions:

1)The intersection of A and B is null ( intersection means element in both list)
2)The Union A and B is equal to the original array. ++(union means total number of element in both list)
3)The number of elements in subset A is minimal.
4)The sum of A's weights is greater than the sum of B's weight.
 Return the subset A in increasing order where the sum of A's weights is greater than the
 sum of B's weights. If more than one subset A exits return the one with the maximal total weight.

 Example
 n= 5
 arr =[3,7,5,6,2]
 The 2 subsets in arr that satisfy the conditions for A are[5,7] and [6,7]:
 1) A is minimal (size 2)
 2) Sum(A) =(5+7) = 12> Sum(B) =(2+3+6) = 11
 3) Sum(A) =(6+7)= 13 > Sum(B) =(2+3+5) = 10
 4) The intersection of A and B is null and their union is equal to arr.
 5) The subset A where the sum of its weight is maximal is[6,7].

 Functional Description
 Complete the minimalHeaviestSetA function in the editor below.

 minimalHeaviestSetA has the following parameter(s):
 int arr[]: an integer array of the weights of item in the set.

 Returns:
 int[]: an integer array with the value of subset A

 Constraints
 1) 1<= n<= 10^5
 2) 1<= arr[i] <= 10^5 (where 0<=i<n)

 Sample Case 0
 Sample input for custom Testing
 arrSize =6
 arr=[5,3,2,4,1,2]
 Output =[4,5]

 The subset of A that satisfies the condition is [4,5]
 1) A is minimal (size)
 2) Sum(A) = (4+5) =9> Sum(B) = (1+2+2+3) = 8
 3) The intersection of A and B is null and their union is equal to arr.
 4) The subset A with the maximal sum is[4,5]
* */

fun optimizingBoxWeights(arr: IntArray): Array<Int> {
    if (arr.isEmpty()) return emptyArray()
    var sortedArray = arr.sortedDescending()
    var totalSum = sortedArray.sumOf { it.toLong() }
    var sumA = 0L
    var list = mutableListOf<Int>()

    for( weight in sortedArray){
        sumA += weight
        list.add(weight)
        println("weight :: $weight")
        println("sumA :: $sumA")
        if (sumA> totalSum-sumA && list.size>=2){
            break
        }
    }

    return list.sorted().toTypedArray()
}

fun main(){
    var list = intArrayOf(5,3,2,4,1,2)
    var i = optimizingBoxWeights(list)
    i.forEachIndexed { index, i ->
        println(i)
    }
}