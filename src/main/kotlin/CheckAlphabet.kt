//Check all the alphabet is available in the string
//"The quick brown fox jumps over the lazy dog"

fun main() {
    var s = "The quick brown fox jumps over the lazy dog"
    var y ="hello"
    println(s +" :: "+checkAlphabet(s))
    println(y +" :: "+checkAlphabet(y))
}

fun checkAlphabet(s : String): Boolean{
    var alphabet =('a'..'z').toSet()
    var removeSpace = s.toLowerCase().filter { it.isLetter() }.toSet()
    return alphabet.all { it in removeSpace }
}