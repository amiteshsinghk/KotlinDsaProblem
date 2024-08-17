//Kotlin Program to divide a string in 'N' equal parts.

fun main(){
    divideStringInNEqualParts("CatDogCna",4)
    divideStringInNParts("CatDogCna",4)
}

fun divideStringInNEqualParts(s:String, parts : Int){
    val newString = mutableListOf<String>()
    val strLength = s.length
    val partSize = strLength/parts
    for (i in 0.. strLength step partSize){
        if (i+partSize <= strLength){
            val item = s.substring(i, i + partSize)
            newString.add(item)
        }
    }
    println(newString)
}

fun divideStringInNParts(s:String, parts : Int){
    val newString = mutableListOf<String>()
    val strLength = s.length
    val partSize = strLength/parts
    for (i in 0.. strLength step partSize){
        if (i+partSize <= strLength){
            val item = s.substring(i, i + partSize)
            newString.add(item)
        }else{
            val diff = (i+partSize)- strLength
            val item = s.substring(i, i+partSize-diff)
            if (item.length >0)  newString.add(item)

        }
    }
    println(newString)
}