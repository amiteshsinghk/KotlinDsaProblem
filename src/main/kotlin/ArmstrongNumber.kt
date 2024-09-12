// Given a number x, determine whether the given number is Armstrong Number or not.
// An Armstrong number (also known as a Narcissistic number or pluperfect digital invariant) is a number
// that is equal to the sum of its own digits each raised to the power of the number of digits.

// 153: 1^3 + 5^3 + 3^3 = 1 + 125+ 27 = 153


fun main() {
    val num = 153
    if (isArmstrong(num.toString())) println("Given number $num is Armstrong number")
    else println("Given number $num is not Armstrong number")

    if (checkArmstrongNumber(num)) println("Given number $num is Armstrong number")
    else println("Given number $num is not Armstrong number")
}

fun isArmstrong(num: String): Boolean {
    val numLength = num.length
    var sumOfDigit = 0
    num.forEachIndexed() { i, _ ->
        val digit = num[i].toString().toInt()
        sumOfDigit += Math.pow(digit.toDouble(), numLength.toDouble()).toInt()
    }
    return sumOfDigit == num.toInt()

}

fun checkArmstrongNumber(num: Int): Boolean {
    var number = num
    val itemLength = number.toString().length
    var sumOfDigit = 0.0
    while (number > 0) {
        val digit = number % 10
        sumOfDigit += Math.pow(digit.toDouble(), itemLength.toDouble())
        number /= 10
    }
//    if (sumOfDigit == num.toDouble()) println("Given $num and their sum of its digit is $sumOfDigit raise to Power $itemLength  is Armstrong number")
//    else println("Given $num and their sum of its digit is $sumOfDigit raise to Power $itemLength  is not Armstrong number")
    return sumOfDigit == num.toDouble()

}