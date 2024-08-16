//Java Program to count the total number of vowels and consonants in a string
//This is a really simple sentence
fun main(){
    var item = countVowelConstant("This is a really simple sentence")
    println("Vowels ${item.first}, Constant ${item.second}")
}
fun countVowelConstant(s: String): Pair<Int, Int> {
    var vowels =0
    var constan =0
    val item  =s.filter { it.isLetter() }
    item.forEachIndexed { index, c ->
        if (isVowel(c)) vowels +=1
        else constan += 1
    }
    return Pair(vowels,constan)
}
fun isVowel(s:Char):Boolean{
    var isValidVowel = false
    when(s){
        'a','e','i','o','u'-> isValidVowel = true
        else -> isValidVowel = false
    }
    return isValidVowel
}