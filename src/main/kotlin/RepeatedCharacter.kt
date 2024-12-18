//Count the number of repeated character in a string.
//class RepeatedCharacter {
//}

fun main() {
    countCharacter("heiwhiheirhnfnn")

}

fun countCharacter(s:String){
    var nonRepeatChar= s.toSet()
    nonRepeatChar.forEachIndexed(){index, chars->
        var count =0
        for(i in 0..s.length-1){
            if(chars == s[i]) count += 1
        }
        if (count >0)println("count of $chars is $count")
    }
}