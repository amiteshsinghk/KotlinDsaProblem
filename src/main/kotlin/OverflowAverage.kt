// Compute average of two numbers without overflow
// formula to safely compute the average without overflow:
// average = (a/2) + (b/2) +((a % 2 +b % 2)/2)

fun main(){
    println(averageOfTwoNumbers(2147483646,2147483647))
}
fun averageOfTwoNumbers(n1: Int, n2: Int): Int{
    return(n1/2 + n2/2)+((n1 % 2 + n2%2)/2)
}