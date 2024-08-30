//Count total path in a maze
//constraint : it will only move in the forward direction or downward
// it  cant't move backward or upward
//|x->|___|___|
//|___|___|___|
//|___|___|___|
//|___|___|___|
fun main(){
    println(calculateTotalPath(3,3,0,0))
    println(calculatePath(i=0,j=0,m=3,n=3))
}

fun calculatePath(i:Int,j:Int,m:Int,n:Int):Int{
    if (i == m || j == n){
        return 0
    }
    if (i == m-1 || j== n-1){
        return 1
    }
    var forwardPath = calculatePath(i+1,j,m,n)
    var backwardPath = calculatePath(i,j+1,m,n)
    return forwardPath + backwardPath
}






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