
fun  main(){
    val item ="efgh"
    val itemLength = item.length
    println(reverseAString(item))
    println(reverseStringUsingRecursion(item,0))
    reverseStringUsingRecursion2(item,itemLength-1)
}

fun reverseAString(s:String): String{
    var reverseString =""
    val itemLength =s.length
    s.forEachIndexed { index, _ ->
        reverseString += s[(itemLength - 1) - index]
    }
    return reverseString
}

fun reverseStringUsingRecursion(s: String, index: Int): String{
    if (index==s.length) {
        return ""
    }
    val newString = reverseStringUsingRecursion(s, index+1)
    return newString + s[index]
}

fun reverseStringUsingRecursion2(s: String, index: Int){
    if (index==0) {
        print(s[index])
        return
    }
    print(s[index])
    reverseStringUsingRecursion2(s, index-1)
}