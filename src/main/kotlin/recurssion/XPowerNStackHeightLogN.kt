package recurssion

/*
* Calculate x^n, where the stack height = logn
* Reference : https://www.youtube.com/watch?v=5Boqfjissv0&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop&index=17
*
* */
fun main() {
    println(calculatePower(2, 5))
    println(calculatePowerRecurssion2(2, 5))
}

fun calculatePower(x: Int, pow: Int): Int {
    if (x == 0) return 0
    if (pow == 0) return 1
    return if (pow % 2 == 0) {
        calculatePower(x, pow / 2) * calculatePower(x, pow / 2)
    } else {
        calculatePower(x, pow / 2) * calculatePower(x, pow / 2) * x
    }
}

fun calculatePowerRecurssion2(x:Int, pow:Int): Int {
    if (x == 0) return 0
    if (pow == 0) return 1
    var res = calculatePowerRecurssion2(x, pow-1)
    return x * res

}