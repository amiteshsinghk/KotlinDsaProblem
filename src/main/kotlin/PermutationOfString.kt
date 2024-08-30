//Kotlin Program to find all the permutations of a string
//ABC=> ABC,ACB,BAC,BCA,CBA,CAB


fun main(){
    val item ="ABC"
    val itemLength = item.length
    findPermutationOfString(item, 0,itemLength)
    findPermutationOfStringRecursion(item,"")

}
fun findPermutationOfStringRecursion(str: String, permutation: String){
    if (str.isEmpty()){
        println(permutation)
        return
    }
    for (i in 0 until str.length){
        val charAt = str[i]

        //abc -> ab
        //substring(0,i) it will not include the last character. So if the i= 0 and str = abc than it will give a
        //substring(i+1) it will the character starting from i+1 till the end. Not i = 1 tha i+1 = 2, than it will give c.
        // So the str.substring(0,i)+str.substring(i+1) will give ac.
        val newString = str.substring(0,i)+str.substring(i+1)
        findPermutationOfStringRecursion(newString,permutation+charAt)
    }
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
    val temp: Char?
    temp = item[i]
    item[i] = item[j]
    item[j] = temp
    return String(item)
}

