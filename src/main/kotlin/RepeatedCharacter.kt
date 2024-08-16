//Count the number of repeated character in a string.
//class RepeatedCharacter {
//}

fun main() {
    countCharacter("heiwhiheirhnfnn")

}

fun countCharacter(s:String){
    var nonRepeatChar= s.toSet()
    nonRepeatChar.forEachIndexed(){index, chars->
        var vount =0
        for(i in 0..s.length-1){
            if(chars == s[i]) vount= vount+1
        }
        if (vount >0)println("count of $chars is $vount")
    }
}