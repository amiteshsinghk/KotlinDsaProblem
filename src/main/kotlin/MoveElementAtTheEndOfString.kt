/*
* Move all an element at the end  of string.
* Input : axbcxxd char-> x
* Output : abcdxxx
* */

fun main(){
    println(moveElementAtTheEnd("axbcxxd",'x'))
    moveElementAtTheEndRecursion("axbcxxd",'x',0,0,"")
}

fun moveElementAtTheEndRecursion(s: String, element: Char, index : Int, count: Int, newString: String){
    if (index == s.length){
        var item = newString
        for (i in 1..count) {
            item += element
        }
       println(item)
        return
    }

    if (s[index] == element) {
        moveElementAtTheEndRecursion(s, element, index + 1, count + 1, newString)
    }else {
        val n =newString+s[index]
        moveElementAtTheEndRecursion(s, element, index + 1, count, n)
    }

}

fun moveElementAtTheEnd(s: String, element: Char):String{
    val newItem = StringBuilder()
    val elementItem = StringBuilder()
    for (i in s.indices){
        if (s[i] == element) elementItem.append(element)
        else newItem.append(s[i])
    }
   return newItem.append(elementItem).toString()
}

