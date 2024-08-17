//Kotlin Program to find all subsets of a string
//The subset of a string is the character or the group of characters that are present inside the string.
fun main(){
    subsetOfString("FUN")
}
fun subsetOfString(s:String){
    val strLength = s.length
    val list = mutableListOf<String>()
    val totalSubset = strLength*(strLength+1)/strLength //To find the total number of subsets n(n+1)/2
    for (i in 0.. totalSubset){
        for ( j in i.. strLength){
            if (j+1 <= strLength){
                val item = s.substring(i, j + 1)
                list.add(item)
            }
        }
    }
    println(list)
}