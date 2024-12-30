//Prime number is a number that is greater than 1 and divided by 1 or itself only.
// In other words, prime numbers can't be divided by other numbers than itself or 1.
// For example 2, 3, 5, 7, 11, 13, 17.... are the prime numbers.

// Print all prime numbers less than or equal to N


// Check given number is prime number
// Input:2, 5, 7,11
// output : True
// Input : 4,6,8, 10
// Output : false
fun main() {
    println(checkNumberIsPrimeNumber(2))
    findAllPrimeNumber(23)
}

fun findAllPrimeNumber(n: Int){
    for (i in 2..n){
        var isPrime = true
        for ( j in 2.. i/2){
            if (i % j == 0) {
                isPrime = false
                break
            }
        }
        if (isPrime) print("$i ")
    }
}

fun checkNumberIsPrimeNumber(s: Int): Boolean {
    if (s <= 1) return false
    for (i in 2.. s/2){
        if (s % i == 0) {
            return false
        }
    }
    return true
}