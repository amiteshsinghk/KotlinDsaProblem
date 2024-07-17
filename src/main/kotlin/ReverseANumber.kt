//Reverse a number.
fun main(){
println(reverseANumber(1234))
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