//Java Program to count the total number of vowels and consonants in a string
//This is a really simple sentence
fun main(){
    var item = countVowelsAndConsonantsUsingRegex("This is a really simple sentence")
    println("Vowels ${item.first}, Constant ${item.second}")
}
fun countVowelsAndConsonantsUsingRegex(s: String): Pair<Int, Int> {
   val vowelRegex ="[aeiouAEIOU]".toRegex()
    val constantRegex ="[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]".toRegex()
    var vowelCount = vowelRegex.findAll(s).count()
    var constantCount = constantRegex.findAll(s).count()
    return Pair(vowelCount,constantCount)
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