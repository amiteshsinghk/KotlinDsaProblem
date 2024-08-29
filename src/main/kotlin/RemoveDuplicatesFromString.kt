/*
* Remove Duplicates from string
*
* */

fun main(){
    removeDuplicatesFromString("aabbccda")
    removeDuplicatesFromStringRecursion("aabbccda",0,"")
}

val mapRecursion = BooleanArray(26)
fun removeDuplicatesFromStringRecursion(s:String, index:Int, newString : String){
    if (index == s.length){
        println("Recursion => $newString")
        return
    }

    if (mapRecursion[s[index] -'a']){
        removeDuplicatesFromStringRecursion(s,index+1,newString)
    }else{
        mapRecursion[s[index] - 'a'] = true
        val newStrings = newString + s[index]
        removeDuplicatesFromStringRecursion(s,index+1,newStrings)
    }
}

fun removeDuplicatesFromString(s:String){
    val newString = StringBuilder()
    val map = BooleanArray(26)
    for (c in s) {
       if (!map[c-'a']){
           map[c-'a'] = true
           newString.append(c)
       }
    }
    println(newString)
}