package interviewQuestion

/*
* You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Test Case 1:
Input: height = [1,1]
Output: 1
Test Case 2:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

* https://docs.google.com/document/d/15hd9H4F3fVtAGEeZrVrsTu2X4gJhnUGK3lXYSRKLOfc/edit?tab=t.0
* */

fun main(){
    var list = listOf(1,8,6,2,5,4,8,3,7)
    println( maxArea(list))
    
}

fun maxArea(height: List<Int>): Int{
    var left = 0
    var right = height.size-1
    var result =0

    while(left< right){
        val width = right-left
        val currentarea = Math.min(height[left],height[right])* width
        result = Math.max(currentarea, result)
        if(height[left]< height[right]){
            left++
        } else right--
    }
    return result
}