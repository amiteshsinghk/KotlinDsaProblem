/*
* Two strings are given word and substr. Some of the character in word in word are a question mark?.
* Find the lexicographically smallest string that can be obtained by replacing"?".
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
    val word = "as?b?e?gf"
    val substr = "dbk"
//    val word = "vfmqdpveacmhigjvejapwxykdatsaoy?b?qbyipxynpdruld??tnjqmwvfjtstjyscsyqkuyddfjo?rnurgspiko??xpcev?hdwwwiitg"
//    val substr = "dbk"
    println(findSmallestStringWithSubstring(word, substr))  // Output: asdbkeagf
}

fun findSmallestStringWithSubstring(word: String, substr: String): String {
    val n = word.length
    val m = substr.length
    if(m > n) return "-1"

    var wordArray = word.toCharArray()
    var smallestResult: CharArray? = null

    for(i in 0..n-m){
        var canPlace = true
        for(j in 0 until m){
            if(wordArray[i + j] != '?' && wordArray[i + j] != substr[j]){
                canPlace = false
                break
            }

        }

        if(canPlace){
            val newWordArray = wordArray.copyOf()

            for(j in 0 until m){
                newWordArray[i + j] = substr[j]

            }
            for(k in newWordArray.indices){
                if(newWordArray[k] == '?'){
                    newWordArray[k] = 'a'
                }

            }

            if(smallestResult == null || String(newWordArray) < String(smallestResult)){
                smallestResult = newWordArray
            }

        }

    }
    return smallestResult?.let { String(it) } ?: "-1"
}


