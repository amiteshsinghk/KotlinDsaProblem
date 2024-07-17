//Relace first char of each word with capital letter.
fun main() {
    val s = "The quick brown fox jumps over the lazy dog"
    firstLetterCapitalLetter(s)
}
fun firstLetterCapitalLetter(s : String){
    val str = s.split(" ")
    var newString =""
    str.forEach(){
    newString+= it.replaceFirstChar { it.titlecase() }+" "
    }
    println(newString)
}
