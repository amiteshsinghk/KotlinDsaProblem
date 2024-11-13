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

/*
********************************************Explanation************************************************************
*

Imagine we have a long shelf where we can place items, and the shelf has dividers. Here's what each symbol represents:
- **`*`**: This symbol represents an item on the shelf, like a box or a product.
- **`|`**: This symbol represents a divider on the shelf, marking the start and end of a section or container.

You’re given a series of items and dividers on the shelf, like this: `"|**|*|*"`. Your job is to figure out how many items (or `*` symbols) are inside closed containers between specified positions.

### Understanding Containers

A container is defined as the space between two dividers (`|`). Only the items (`*`) that are fully enclosed by two dividers are counted as being "in the container."

For example:
- In `"|**|*|*"`, there are two closed containers:
  - The first container, `"|**|"`, has two items.
  - The second container, `"|*|"`, has one item.

If there’s an item (`*`) outside of two dividers, it doesn’t count as being in a container.

---

### Input Breakdown

1. **String `s`**: A long sequence of items (`*`) and dividers (`|`).
2. **startIndices and endIndices**: Lists that specify the start and end points for checking different sections of `s`.
   - For each pair of start and end indices, we need to calculate how many items are within closed containers in that part of the shelf.

---

### Example Walkthrough

Let’s say:
- `s = "|**|*|*"`
- `startIndices = [1, 1]`
- `endIndices = [5, 6]`

This means we have two queries:
1. **First Query**: Count items in containers from position 1 to 5.
   - In `"|**|*"`, there’s one container `"|**|"` with **2 items** inside.
2. **Second Query**: Count items in containers from position 1 to 6.
   - In `"|**|*|"`, there are two containers: `"|**|"` with **2 items** and `"|*|"` with **1 item**, so **total items = 3**.

### Breaking Down the Solution

To solve this problem efficiently, let’s precompute some information so we can answer each query quickly.

---

### Step-by-Step Solution in Simple Terms

#### Step 1: Precompute the Total Items Up to Each Position

Imagine walking down the shelf and keeping track of the total number of items (`*`) you've seen so far at each point.

1. We start from the beginning of `s` and move to the end.
2. Every time we see an item (`*`), we add it to our count.
3. We store the cumulative count of items at each position.

This way, for any given position, we know the total number of items up to that point without having to count them again.

#### Analogy

Think of this like counting items in a warehouse aisle as you walk down it. At any point, you know the total number of items you've passed without having to go back and count each one again.

---

#### Step 2: Identify the Nearest Dividers on the Left and Right of Each Position

To know if items are within a container, we need to find the closest left and right dividers (`|`) around each position.

1. **Left Dividers**: Starting from the left end of `s`, for each position, record the location of the most recent divider we encountered.
2. **Right Dividers**: Starting from the right end of `s`, for each position, record the location of the nearest divider to the right.

With these two arrays, we can quickly determine if any given start and end positions in a query are enclosed by dividers.

#### Analogy

Imagine looking for sections on a shelf with bookends (dividers). For any book, you can look left to see the nearest left bookend and right to see the nearest right bookend. This tells you if the book is in a closed section.

---

#### Step 3: Process Each Query Using the Precomputed Information

Now, for each query (start and end indices):

1. Convert the provided start and end indices from 1-based (human-friendly) to 0-based (computer-friendly).
2. Use the precomputed **right divider** of `start` to find the first divider after or at `start`.
3. Use the precomputed **left divider** of `end` to find the last divider before or at `end`.
4. If the left divider is at or after the right divider, it means we have a closed container between the dividers.

Using the cumulative item count, we can quickly calculate the number of items between these dividers:
   - **Items in Container** = Total items at the right divider - Total items at the left divider.

#### Analogy

Think of this like checking if two bookends fully enclose some books on a shelf. If they do, you count the books in between. Using cumulative counts, you know the total number of books up to each bookend, so you only need to subtract to get the exact count between them.

---

### Final Code Explanation in Non-Technical Terms

Here’s the Kotlin code that implements this approach, and we'll go through each part in plain language.

kotlin
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


### Summary

1. **Count Items as You Walk Along the Shelf**: `itemCount` keeps track of the cumulative total of items (`*`) at each position.
2. **Mark Nearest Left and Right Dividers**: `leftPipe` and `rightPipe` arrays store the nearest dividers on the left and right, helping to define closed containers.
3. **Use Precomputed Information for Each Query**: For each start and end in the queries, find the nearest dividers and calculate the items inside the container in constant time.

This approach ensures we only walk down the shelf once to set up our "map" of item counts and dividers, allowing us to answer each query quickly without recounting.

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


