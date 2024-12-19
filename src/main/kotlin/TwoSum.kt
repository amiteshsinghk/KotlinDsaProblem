/**
*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

* */

fun main() {
    val i= intArrayOf(1,3, 2, 3, 4, 5,3)
    println(twoSum(i,6).joinToString())
    println(findTwoSum(i.toList(),6))

}

fun findTwoSum(numbers: List<Int>, target: Int): List<Pair<Int, Int>> {
    val seen = mutableSetOf<Int>()
    val result = mutableSetOf<Pair<Int, Int>>()

    for (num in numbers) {
        val complement = target - num
        if (seen.contains(complement)) {
            result.add(Pair(complement, num))
        }
        seen.add(num)
    }

    return result.toList()
}

fun twoSum(nums: IntArray, target: Int) : IntArray{
    var arra = intArrayOf()
    loop@  for(i in nums.indices){
        for(j in i+1 until(nums.size)){
            if(target == nums[i] + nums[j]){
                arra = arra.plus(i).plus(j)
                break@loop
            }
        }

    }
    return arra
}
