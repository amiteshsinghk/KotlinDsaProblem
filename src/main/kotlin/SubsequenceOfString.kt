/*
* Find the subsequence of string
* Input: ABC
* Output: ABC,AB,AC,A,BC,B,C,
* reference : https://www.youtube.com/watch?v=u-HgzgYe8KA&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop&index=20
* */

fun main(){
    subsequenceOfString("ABC",0,"")
}

fun subsequenceOfString(s: String, index : Int, newString: String){
    if (index == s.length){
        println(newString)
        return
    }
    // In first case it will take the character
    val newChar = s[index]
    subsequenceOfString(s, index + 1, newString+newChar)
    // In second case it will not take the character
    subsequenceOfString(s,index+1,newString)


}