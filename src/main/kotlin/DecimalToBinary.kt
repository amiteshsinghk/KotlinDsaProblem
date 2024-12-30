// Write a Program to Change Decimal Number to Binary?
// Input: 17
// Output: 10001

// Write a Program to Change Binary to Decimal Number?
// Input: 10001
// Output: 17

/*
* To convert a decimal number to binary, you can use the division-by-2 method, where you repeatedly divide the number by 2 and keep track of the remainders. The binary representation is obtained by reading these remainders from the last to the first.

Here's how you can do it in code without using any built-in conversion functions:

Step-by-Step Process:
Divide the decimal number by 2.
Record the remainder (0 or 1).
Update the number to be the quotient of the division.
Repeat until the number becomes 0.
The binary representation is the sequence of remainders read from bottom to top.
* */

fun main() {
    println(convertDecimalToBinary(19))
    println(binaryToDecimals("10001"))
    println(convertBinaryToDecimalHack(10011))
    println(decimalToBinarys(19))
}

fun decimalToBinarys(num:Int):Int{
    return num.toString(2).toInt()
}

fun convertBinaryToDecimalHack(binary:Int):Int{
    return binary.toString().toInt(2)

}
//Write a Program to Change Binary to Decimal Number?
fun binaryToDecimals(binary: String): Int {
    var decimal = 0
    var base = 1
    for (i in binary.length - 1 downTo 0) {
        val digit = binary[i].toString().toInt()
        decimal += (digit * base)
        base *= 2
    }
    return decimal
}

// Write a Program to Change Decimal Number to Binary?
fun convertDecimalToBinary(num: Int): String {
    var number = num
    var binaryConversion = ""

    while (number > 0) {
        binaryConversion = (number % 2).toString() + binaryConversion
        number /= 2
    }
    return binaryConversion
}