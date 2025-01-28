//Reverse a number.
fun main(){
println(reverseNum(1234))
}
fun reverseNum(num: Int): Int{
    var item = num
    var newNum = 0
    while (item> 0){
        var i = item % 10
        newNum = newNum *10 + i
        item = item /10
    }
     return newNum
}


fun reverseANumber(i : Int): Int{
    var num = i
    var sum = 0
    while(num>0){
        val y = num % 10
        sum = sum*10 + y
        num /= 10
    }
    return sum
}