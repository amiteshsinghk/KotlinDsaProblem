//Count total path in a maze
//constraint : it will only move in the forward direction or downward
// it  cant't move backward or upward
//|x->|___|___|
//|___|___|___|
//|___|___|___|
//|___|___|___|
fun main(){
    println(calculateTotalPath(3,4,0,0))
}
/*
m is the row of the matrix
n is the column of the matrix
i and j is the coordinate of the matrix
*/

fun calculateTotalPath(m: Int, n: Int,i: Int,j: Int) : Int{
    if (i == m || j == n){
        return 0
    }
    if (i == m-1 || j == n-1){
        return 1
    }
    //move forward
    val forwardPath = calculateTotalPath(m,n, i+1,j)
    //move downward
    val downwardPath = calculateTotalPath(m,n, i,j+1)
    return forwardPath + downwardPath
}