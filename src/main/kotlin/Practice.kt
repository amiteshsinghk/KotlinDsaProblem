/*
* Two strings are given word and substr. Some of the character in word in word are a question mark?.
* Find the lexicorgraphically smallest string that can be obtained by replacing"?".
* Character such that substr appears at least once. If it is not possible to do so, return -1

Note: A substring is a contiguous secquence of characters within a string. For example,"bcd" is a substring of"abcde" but "ac" is not.
For two strings a and b of the same  length, a is lexicographically smaller tha b if ai< bi for some 0<= i < |a|, and aj = bj  for all 0<= j<= i.

Example
word ="as?b?e?gf"
substr ="dbk".

Replace the 3rd and 5th characters with 'd' and 'k' to get "asdbke?gf" which has substr = "dbk" as a
substring. Replace the remaining '?' with 'a'. The final string is "asdbkeagf".
* */

// Test
fun main() {
//    val word = "as?b?e?gf"
//    val substr = "dbk"
    val word = "vfmqdpveacmhigjvejapwxykdatsaoy?b?qbyipxynpdruld??tnjqmwvfjtstjyscsyqkuyddfjo?rnurgspiko??xpcev?hdwwwiitg"
    val substr = "dbk"
    println(findSmallestStringWithSubstring(word, substr))  // Output: asdbkeagf
}

//fun getSmallestString(str: String, subStr: String){
//    val strLength = str.length
//    val subStrLength = subStr.length
//
//    for (i in 0 until strLength){
//        for ( j in 0 until strLength){
//            if (str[i] != '?' && )
//        }
//    }
//
//}

// Function to check if we can place substr at position i in word
fun canPlaceSubstringAtPosition(i: Int, word: String,substr: String): Boolean {
    for (j in 0 until substr.length) {
        if (word[i + j] != '?' && word[i + j] != substr[j]) {
            return false
        }
    }
    return true
}

fun findSmallestStringWithSubstring(word: String, substr: String): String {
    val n = word.length
    val m = substr.length
    // Try to place substr at each valid position in word
    for (i in 0..n - m) {
        if (canPlaceSubstringAtPosition(i,word, substr)) {
            // Create a mutable result list from word
            val result = word.toCharArray()

            // Place substr at position i and replace '?' with corresponding characters
            for (j in 0 until m) {
                result[i + j] = substr[j]
            }

            // Replace remaining '?' with 'a' for the lexicographically smallest string
            for (k in result.indices) {
                if (result[k] == '?') {
                    result[k] = 'a'
                }
            }

            // Convert result back to string and return it
            return String(result)
        }
    }

    // If no valid placement found, return "-1"
    return "-1"
}


