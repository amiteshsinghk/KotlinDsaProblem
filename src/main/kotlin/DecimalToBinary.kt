// Write a Program to Change Decimal Number to Binary?
// Input: 17
// Output: 10001

// Write a Program to Change Binary to Decimal Number?
// Input: 10001
// Output: 17

fun main() {
    println(convertDecimalToBinary(19))
    println(binaryToDecimals("10001"))
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