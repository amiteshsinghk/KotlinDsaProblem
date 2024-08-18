//Kotlin Program to find the longest repeating sequence in a string


fun main(){
    val item = "acbdfghybdf"
    var lrs = ""
    val itemLength = item.length
    for (i in 0 until itemLength){
        for (j in i+1 until itemLength){
            val x = longestRepeatingSequence(item.substring(i, itemLength), item.substring(j, itemLength))
            if (x.length >lrs.length)lrs = x
        }
    }
    print(lrs)
}

fun longestRepeatingSequence(s:String, t: String): String{
    val minNumber = Math.min(s.length, t.length)
    for (i in 0 until minNumber) {
        if (s[i] != t[i])  return s.substring(0, i)
    }
    return s.substring(0, minNumber)
}

