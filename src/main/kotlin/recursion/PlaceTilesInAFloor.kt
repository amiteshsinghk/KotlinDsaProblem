package recursion

/*
    Place Tiles of size 1xm in a floor of size n*m
    input : n=4, m=2
    Output : 5
*/
fun main() {
    println(placeTilesInAFloor(4, 2))
}

fun placeTilesInAFloor(n: Int, m: Int): Int {
    if (n == m) return 2
    if (n < m) return 1
//  verticalPlacement
    val verticalPlacement = placeTilesInAFloor(n - m, m)
//  Horizontal Placement
    val horizontalPlacement = placeTilesInAFloor(n - 1, m)
    return horizontalPlacement + verticalPlacement
}