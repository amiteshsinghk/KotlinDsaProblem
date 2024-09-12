// Program to Check if a Given String is Palindrome

fun main(){
    println(isPalindrome("abba"))
}

fun isPalindrome(s: String): Boolean{
    val item = s
    val itemLength = item.length
    var isPalim = true
    for (i in 0 until (itemLength)/2){
        if (item[i] != item[(itemLength-1)-i]) {
            isPalim = false
            break
        }
    }
    return isPalim
}