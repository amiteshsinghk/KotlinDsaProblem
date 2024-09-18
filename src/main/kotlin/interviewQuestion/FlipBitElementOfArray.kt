package interviewQuestion

/*
An aspiring programmer is gearing up for the upcoming womens cup coding competition.
During the practice the programmer comes across a question. Where the contestent
is required to find the minimum number of operations require to make all the integers of a given array equal.

In a single operation, one can flip any bit of element of the array.
Considering the given array, arr=[1,2,3] in one operation either 1 can be made
equal to 0,3,5,9 etc 2 can be made 0,3,6,10, etc. or 3can be mad into 2,1,7
*/

fun main() {
    val arr = listOf(1,2,3)  // Example input

    val minOperations = findMinimumOperations(arr)
    println("Minimum number of operations required: $minOperations")
}

fun findMinimumOperations(arr: List<Int>): Int {
    val maxVal = arr.maxOrNull() ?: return 0
    val maxBits = Integer.toBinaryString(maxVal).length

    // Set to hold all unique numbers in the array
    val uniqueNumbers = arr.toSet()

    // Initialize minimum operations to a high value
    var minOperations = Int.MAX_VALUE

    // Iterate through each unique number to use as the target
    for (target in uniqueNumbers) {
        var currentOperations = 0

        // Calculate total flips needed to convert all elements to the current target
        for (num in arr) {
            currentOperations += countBitFlips(num, target, maxBits)
        }

        // Update the minimum operations needed
        minOperations = minOf(minOperations, currentOperations)
    }

    return minOperations
}

// Function to count bit flips required to convert `a` to `b`
fun countBitFlips(a: Int, b: Int, maxBits: Int): Int {
    var flips = 0
    var xored = a xor b // XOR gives 1 where bits are different

    // Count the number of 1s in the XOR result
    while (xored > 0) {
        flips += xored and 1
        xored = xored shr 1
    }
    return flips
}
