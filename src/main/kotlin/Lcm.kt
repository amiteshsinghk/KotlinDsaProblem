// Program to find LCM of two numbers
//  LCM(a,b)=∣a×b∣
//          ----------
//            HCF(a,b)
// LCM(a,b) = |a*b|/ HCF(a,b)

fun main(){

    println(findLCM(12,15))
}
fun findLCM(num1: Int, num2:Int): Int{
    return (num1 * num2)/findHCFc(num1,num2)

}

fun findHCFc(num1: Int, num2: Int): Int{
    var a= num1
    var b= num2
    while (b != 0){
        val temp = b
        b = a % b
        a = temp
    }
    return a
}
