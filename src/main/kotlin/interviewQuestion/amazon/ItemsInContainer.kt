package interviewQuestion.amazon

/*
*
 Items In a container

 Amazon would like to know how much inventory exist in their closed inventory compartments.
 Given a string s consisting of items as "*" and a closed compartments as an open and close "|",
 an array of starting indices startindices, and an array of ending endindices, determine the
 number of items, in closed compartments within the substring between the two indices, inclusive.

 1) An item is represented as an asterisk("*" = ascii decimal 42)
 2) A compartment is represented as a pair of pipes that may or may not have items between them('|' = ascii decimal124).

 Example
 s ='|**|*|*'
 startindices = [1,1]
 endindices = [5,6]

 The string has a total of 2 closed compartments, one with 2 items and one with 1 items. For the first pair
 of indices,(1,5), the substring is '|**|*.
 There are 2 items in a compartment.
 For the second pair of indices,(1,6) the substring is'|**|*|' and there are 2+1 = 3 items in compartments.
 Both of the answers are returned in a array,[2,3].

 Function Description.
 Complete the numberOfItems function in the editor below. The function must return an integer array that contains
 the results for each of the startIndices[i]
 and endIndices[i]pairs.

 numberOfItems has three parameters:
 s: A string to evaluate
 startIndices: An integer array, the starting indices.
 endIndices: An integer array, the ending indices.

 Constraints
 1<=m, n<= 10^5
 1<= startIndices[i] <= endIndices[i]<= need
 Each character of s is either '*' or '|'

 Sample Input For Custom Testing
 s = "*|*|"
 startIndices[] size n = 1
 startIndices = 1
 endIndices[] size n = 1
 endIndices = 3
 Sample Output =0

 Explanation
 s=*|*|
 n = 1
 startIndices =[1]
 n = 1
 startIndices =[3]
 The substring from Index =1 to index = 3 is '*|*'.
 There is no compartments in this string.


 Sample Case 1
 Sample Input for custom Testing

 s="*|*|*|"
 startIndices[] size n = 1
 startIndices =1
 endIndices[] size n =1
 endIndices = 6
 SampleOutput = 2
 Explanation
 s ='*|*|*|'
 n = 1
 startIndices =[1]
 n = 1
 endIndices =[6]

 The string from Index = 1 to index = 6 is '*|*|*|'.
 There are two compartments in this string at (index=2, index =4) and(index =4. index =6).
 There are 2 items between these compartments.
* */

fun main(){
    val s = "|**|*|*"
    val startIndices = intArrayOf(1, 1)
    val endIndices = intArrayOf(5, 6)
    println(numberOfItems(s, startIndices, endIndices)) // Expected output: [2, 3]
}


fun numberOfItems(s: String, startIndices: IntArray, endIndices: IntArray): List<Int> {
    val n = s.length
    val itemCount = IntArray(n)
    val leftPipe = IntArray(n) { -1 }
    val rightPipe = IntArray(n) { -1 }

    // Step 1: Precompute cumulative item counts
    var itemCounter = 0
    for (i in s.indices) {
        if (s[i] == '*') {
            itemCounter++
        }
        itemCount[i] = itemCounter
    }

    // Step 2: Precompute leftPipe positions
    var lastPipe = -1
    for (i in s.indices) {
        if (s[i] == '|') {
            lastPipe = i
        }
        leftPipe[i] = lastPipe
    }

    // Step 3: Precompute rightPipe positions
    lastPipe = -1
    for (i in s.indices.reversed()) {
        if (s[i] == '|') {
            lastPipe = i
        }
        rightPipe[i] = lastPipe
    }

    // Step 4: Process each query
    val result = mutableListOf<Int>()
    for (q in startIndices.indices) {
        val start = startIndices[q] - 1 // Convert to 0-based index
        val end = endIndices[q] - 1 // Convert to 0-based index

        // Find the nearest pipe positions within the range
        val leftBound = rightPipe[start]
        val rightBound = leftPipe[end]

        if (leftBound != -1 && rightBound != -1 && leftBound <= rightBound) {
            result.add(itemCount[rightBound] - itemCount[leftBound])
        } else {
            result.add(0) // No valid container in this range
        }
    }

    return result
}


