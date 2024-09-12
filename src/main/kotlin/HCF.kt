// Write a program to find HCF of two numbers without using recursion.

fun main() {
    println(findHCF(12, 144))
    println(findHcfRecursion(12, 143))
}


fun findHcfRecursion(num1: Int, num2: Int): Int {
    return if (num2 == 0) {
        num1
    } else {
        findHcfRecursion(num2, num1 % num2)
    }

}

fun findHCF(num1: Int, num2: Int): Int {
    var a = num1
    var b = num2
// The algorithm works by repeatedly setting the larger number to the remainder of dividing the
// larger number by the smaller one until the remainder is 0. The last non-zero remainder is the HCF.
    while (b != 0) {
        val temp = b
        b = a % b
        a = temp
    }
    return a
}