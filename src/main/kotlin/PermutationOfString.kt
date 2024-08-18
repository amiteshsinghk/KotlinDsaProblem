//Kotlin Program to find all the permutations of a string
//ABC=> ABC,ACB,BAC,BCA,CBA,CAB


fun main(){
    val item ="ABC"
    val itemLength = item.length
    findPermutationOfString(item, 0,itemLength)

}
fun findPermutationOfString(s:String, startIndex:Int, endIndex:Int){
    if (startIndex == endIndex-1) println(s)// printing the value when the loop item complete
    else{
        for (i in startIndex until endIndex){
            val x= swipeNumber(s, startIndex,i)
            findPermutationOfString(x, startIndex+1,endIndex) // recurring call the function with new swiped string
        }
    }
}

fun swipeNumber(s:String, i:Int, j :Int) : String{
    val item = s.toCharArray()
    var temp :Char? = null
    temp = item[i]
    item[i] = item[j]
    item[j] = temp
    return String(item)
}



























/*fun main(){
    var item =  "ABC"
    var itemLength = item.length
    generatePermutation(item,0,itemLength)
}
fun generatePermutation(str: String, start: Int, end: Int) {
    if (start == end - 1) {
        println(str)
    } else {
        for (i in start until end) {
            // Swapping the string by fixing a character
            val swappedStr = swipeCharacter(str, start, i)
            // Recursively calling function generatePermutation() for rest of the characters
            generatePermutation(swappedStr, start + 1, end)
            // Backtracking is automatically handled as strings are immutable in Kotlin
        }
    }
}

fun swipeCharacter(s:String, i: Int, j : Int ):String{
    val item = s.toCharArray()
    var temp :Char?=null
    temp = item[i]
    item[i] =item[j]
    item[j] = temp
    return String(item)
}*/
