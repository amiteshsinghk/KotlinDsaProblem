//Kotlin Program to determine whether two strings are the anagram
//Two Strings are called the anagram if they contain the same characters. However, the order or sequence of the characters can be different.
/*
In Kotlin, sort() and sorted() are both used to arrange elements in a collection in a specific order, but they have key differences in their usage and behavior:

sort()
Mutates the Original Collection: The sort() function directly modifies the original collection (e.g., a mutable list or array). It rearranges the elements in place.
Returns Unit: Since it modifies the collection in place, sort() doesn't return anything (its return type is Unit).
Applicable to Mutable Collections: You can use sort() on mutable collections like MutableList, MutableSet, or Array.
val mutableList = mutableListOf(4, 2, 3, 1)
mutableList.sort()
println(mutableList) // Output: [1, 2, 3, 4]


sorted()
Does Not Mutate the Original Collection: The sorted() function does not alter the original collection. Instead, it creates a new list with the elements sorted.
Returns a New List: sorted() returns a new list containing the elements in sorted order.
Applicable to Any Collection: You can use sorted() on any collection, whether mutable or immutable.
val list = listOf(4, 2, 3, 1)
val sortedList = list.sorted()
println(sortedList) // Output: [1, 2, 3, 4]
println(list) // Output: [4, 2, 3, 1] - Original list remains unchanged
*/

fun main(){
    checkAnagram("Brag","Grab")
}

fun checkAnagram(s1:String, s2:String){
  if (s1.length != s2.length) {
      println("$s1 and $s2 is not Anagram.")
      return
  }
    //Here string is converted to char array and sorted in ascending order.
    val item1= s1.lowercase().toCharArray().sorted()
    val item2 = s2.lowercase().toCharArray().sorted()
    if (item1 == item2) println("$s1 and $s2 is Anagram.")
    else println("$s1 and $s2 is not Anagram.")
}