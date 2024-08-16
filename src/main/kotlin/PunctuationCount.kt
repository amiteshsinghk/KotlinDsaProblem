//Java Program to Count the Total Number of Punctuation Characters Exists in a String
//(!, . , ' , - , " , ? , ; )

fun main(){
println("countPunctuationMark :: "+ countPunctuationMark("He said, 'The mailman loves you.' I heard it with my own ears."))

}

fun countPunctuationMark(s: String): Int{
    var count = 0
    for (i in s.indices){
//    s.forEachIndexed(){index, c ->
        if (isParanthesisExist(s[i])) count +=1
    }
    return count
}

fun isParanthesisExist(s:Char):Boolean{
    var isValid= false
    when(s){
        '!' -> isValid = true
        '.' -> isValid = true
        '\'' -> isValid = true
        '-' -> isValid = true
        '\"' -> isValid = true
        '?' -> isValid = true
        ';' -> isValid = true
        ',' -> isValid = true

    }
    println("s: $s isvalid $isValid")
    return isValid
}