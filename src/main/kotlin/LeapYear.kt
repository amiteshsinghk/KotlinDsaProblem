// Program to check if a given year is leap year
// The year is a leap year if “any one of ” the following conditions are satisfied:
// 1. The year is multiple of 400.
// 2. The year is a multiple of 4 and not a multiple of 100.
// Leap years: 2000, 2004, 2008, 2012, 2016, 2020, 2024

fun main(){
    println(checkLeapYear(2024))
}

fun checkLeapYear(year: Int): Boolean{
    val num = year
    return num % 400 == 0 || (num % 100 != 0 && num % 4 == 0)
}
