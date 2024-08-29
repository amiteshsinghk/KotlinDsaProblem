package recurssion

/*
* print tower of hanoi
* The Tower of Hanoi is a mathematical puzzle where you need to move a stack of discs from one peg to another, using a third peg as a helper, following these rules:

* Move only one disc at a time.
* A disc may only be placed on top of a larger disc or on an empty peg.
* You must use the helper peg to move discs around.
*
* Implementation
* Moving n-1 discs to an auxiliary peg.
* Moving the nth disc directly to the destination peg.
* Moving the n-1 discs from the auxiliary peg to the destination peg.
* time complexity O(2^n-1)
* */

fun main() {
    towerOfHanoi(3, "S", "H", "D")
}

fun towerOfHanoi(n: Int, source: String, helper: String, dest: String) {
    if (n == 1) {
        println("Transfer disc $n from source $source to $dest")
        return
    }
    towerOfHanoi(n - 1, source, dest, helper)
    println("Transfer disc $n from source $source to $dest")
    towerOfHanoi(n - 1, helper, source, dest)
}