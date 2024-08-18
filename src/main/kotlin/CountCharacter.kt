//Kotlin Program to count the total number of characters in a string
fun main(){
  println("count characters using inbuilt Function ::"+countCharactersUsingInbuiltFunction("The best of both worlds"))
    println("count characters Without using inbuilt Function ::"+countCharacterWithoutUsingInbuiltFunction("The best of both worlds"))
}
fun countCharactersUsingInbuiltFunction(s : String):Int{
    return s.filter { it.isLetter() }.length
}

fun countCharacterWithoutUsingInbuiltFunction(s : String) : Int{
    var count = 0
    s.forEachIndexed { index, c ->
        if (c != ' ') count += 1
    }
    return count
}