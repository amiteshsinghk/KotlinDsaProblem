/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false


Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.*/

fun main() {
    println(isValid("(}"))

}

fun isValid(s: String): Boolean {
    var temp: Char? = null
    var isValidString = true
    s.forEachIndexed loop@{ index, s ->
        if ((index % 2 == 0 && index > 1) || index == 0) {
            temp = s
        } else {
            when (temp) {
                '(' -> if (s != ')') {
                    isValidString = false
                    return@loop
                }
                '{' -> if (s != '}') {
                    isValidString = false
                    return@loop
                }
                '[' -> if (s != ']') {
                    isValidString = false
                    return@loop
                }
                '<' -> if (s != '>') {
                    isValidString = false
                    return@loop
                }
            }
        }


    }
    return isValidString
}