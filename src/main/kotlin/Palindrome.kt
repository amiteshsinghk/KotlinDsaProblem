// Program to Check if a Given String is Palindrome

fun main(){
    println(isPalindrome("0P"))
    println(isPalindrome("A man, a plan, a canal: Panama"))
}

fun isPalindrome(s: String): Boolean{
    val item = s.filter{it.isLetter() || it.isDigit()}.lowercase().toCharArray()
    val itemLength = item.size
    var isPalim = true
    for (i in 0 until (itemLength)/2){
        if (item[i] != item[(itemLength-1)-i]) {
            isPalim = false
            break
        }
    }
    return isPalim
}