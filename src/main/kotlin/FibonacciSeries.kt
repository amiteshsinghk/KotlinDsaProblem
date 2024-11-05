// Write a programme to print fibonacci Series
// In fibonacci series, next number is the sum of previous two numbers
// for example 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 etc. The first two numbers of fibonacci series are 0 and 1.

//Write a kotlin Program to generate Fibonacci Triangle.

fun main() {
    printFibonacciSeries(10)
    println()
    fibonacciTriangle(3)
}

//Write a kotlin Program to generate Fibonacci Triangle.
//n= number of rows
fun fibonacciTriangle(num: Int) {
    var firstNum = 0
    var secondNum = 1
    for (i in 1..num) {
        for (j in 1..i) {
            print("$firstNum ")
            // Calculate the next Fibonacci number
            val next = firstNum + secondNum
            firstNum = secondNum
            secondNum = next
        }
        println() // Move to the next row
    }
}

// Write a programme to print fibonacci Series
fun printFibonacciSeries(num: Int) {
    var firstNum = 0
    var secondNum = 1
    var sum: Int
    print("$firstNum $secondNum ")
//  as two number is already printed. So we need to subtract the 2 from total count.
    for (i in 1..num - 2) {
        sum = firstNum + secondNum
        print("$sum ")
        firstNum = secondNum
        secondNum = sum

    }
}