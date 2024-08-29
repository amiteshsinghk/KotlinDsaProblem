/*
* Check array is sorted
* */

fun main(){
    var list = mutableListOf<Int>()
    list.add(1)
    list.add(2)
    list.add(3)
    list.add(4)
    list.add(5)
    println(isArraySorted(list))
    println(isArraySortedRecursion(list,0))
    println(isArraySortedRecursion2(list,0))
}

fun isArraySorted(list : MutableList<Int>): Boolean{
    var previousItem=-1

    list.forEachIndexed{index, ch->
        if(previousItem<0) previousItem = ch
        if (ch <= previousItem && index != 0) return false
        previousItem = ch
    }
    return true
}

fun isArraySortedRecursion(list : MutableList<Int>, index: Int): Boolean{
    if (index == list.size-1 || list.isEmpty()) return true
    if (list[index] < list[index+1]){
        return isArraySortedRecursion(list,index+1)
    } else return false
}

fun isArraySortedRecursion2(list : MutableList<Int>, index: Int): Boolean{
    if (index == list.size-1 || list.isEmpty()) return true
    if (list[index] >= list[index+1]){
        return false
    }
    return isArraySortedRecursion2(list, index+1)
}