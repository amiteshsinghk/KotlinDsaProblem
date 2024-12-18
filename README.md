**1. Two Sum**
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
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

**2. Valid Parentheses**
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

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
s consists of parentheses only '()[]{}'.

3. Check all the alphabet is available in the string
   input :"The quick brown fox jumps over the lazy dog"
   output : true
   input :"The quic brown fox jumps over the lazy dog"
   output : false
4. Replace first char of each word with capital letter.
   input : "The quick brown fox jumps over the lazy dog"
   output : The quick brown fox jumps over the lazy dog
5. Reverse a number
   input: 123
   output: 321
6. Count the number of repeated character in a string.
   input : "heiwhiheirhnfnn"
   output : count of h is 4
   count of e is 2
   count of i is 3
   count of w is 1
   count of r is 1
   count of n is 3
   count of f is 1
7. CountCharacter :Kotlin Program to count the total number of characters in a string
   input : "heiwhiheirhnfnn"
   output : 15
8. PunctuationCount :Kotlin Program to Count the Total Number of Punctuation Characters Exists in a String
   input : "He said, 'The mailman loves you.' I heard it with my own ears."
   output :  5
9. VowelConstantCount : Kotlin Program to count the total number of vowels and consonants in a string
   input :"This is a really simple sentence"
   output : Vowels 10, Constant 17
10. Anagram :Kotlin Program to determine whether two strings are the anagram.
    input :"Brag","Grab"
    output : Brag and Grab are Anagram
    input : "Braig","Grajb"
    output : Braig and Grajb are not Anagram

11. DivideStringInEqualPart : Kotlin Program to divide a string in 'N' equal parts.
    input : "CatDogCn" part 4
    output : [Ca, tD, og, Cn]
    input : "CatDogCna" part 4
    output : [Ca, tD, og, Cn]
12. SubsetOfString : Kotlin Program to find all subsets of a string
    input :"FUN"
    output : [F, FU, FUN, U, UN, N]
13. RepeatingSequenceOfString : Kotlin Program to find the longest repeating sequence in a string
    input : "acbdfghybdf"
    output : bdf
14. PermutationOfString : Kotlin Program to find all the permutations of a string
15. Stack : InsertAtBottomStack : insert an integer at the bottom of a stack
    Input : [1, 2, 3]
    output : [5, 1, 2, 3]
16. Reverse a stack
    Input : [1, 2, 3]
    Output : [3, 2, 1]
17. TowerOfHanoi : print tower of hanoi 
    input: 3
    output: Transfer disc 1 from source S to D
            Transfer disc 2 from source S to H
            Transfer disc 1 from source D to H
            Transfer disc 3 from source S to D
            Transfer disc 1 from source H to S
            Transfer disc 2 from source H to D
            Transfer disc 1 from source S to D
18. ReverseAString : Reverse a string using iterator and recursion.
19. TowerOfHanoi : print tower of hanoi
    Explanation:
    The Tower of Hanoi is a mathematical puzzle where you need to move a stack of discs from one peg to another, using a third peg as a helper, following these rules:
    Move only one disc at a time.
    A disc may only be placed on top of a larger disc or on an empty peg.
    You must use the helper peg to move discs around.
    Implementation
    Moving n-1 discs to an auxiliary peg.
    Moving the nth disc directly to the destination peg.
    Moving the n-1 discs from the auxiliary peg to the destination peg.
20. XPowerNStackHeightLogN : Find first and Last occurrence of an element in a string.
    Input : abaacdaefaah
    Output : first occurrence is 0 and second is 10 
21. FirstAndLastOccurrenceOfElement : Find first and Last occurrence of an element in a string.
    Input : "abaacdaefaah" char "a"
    Output : first = 0 last = 10
22. ArrayIsSorted : Check array is sorted
    Input : [1,2,3,3]
    Output : false
    Input : [1,2,3,4]
    Output : true
23. MoveElementAtTheEndOfString : Move all an element at the end  of string.
    Input : axbcxxd char-> x 
    Output : abcdxxx
24. RemoveDuplicatesFromString : Remove Duplicates from string    
    Input : aabbccda
    Output : abcd
25. Imp : SubsequenceOfString : Find the subsequence of string
    Input: ABC
    Output: ABC,AB,AC,A,BC,B,C,
26. constraint : it will only move in the forward direction or downward
    it  can't move backward or upward
    Input : 3,3
    Output : 6
27. Place Tiles of size 1xm in a floor of size n*m
    input : n=4, m=2
    Output : 5
28. Find the number of ways in which you can invite n people to your party, single or in pairs
    Input : 4
    Output : 10
29. Bubble Sort
30. Selection Sort
31. Insertion Sort
32. DecimalToBinary: Write a Program to Change Decimal Number to Binary?
    Input: 17
    Output: 10001
33. Write a Program to Change Binary to Decimal Number?
    Input: 10001
    Output: 17
34. ArmstrongNumber: Given a number x, determine whether the given number is Armstrong Number or not.
    An Armstrong number (also known as a Narcissistic number or pluperfect digital invariant) is a number
    that is equal to the sum of its own digits each raised to the power of the number of digits.
    Input : 153: 1^3 + 5^3 + 3^3 = 1 + 125+ 27 = 153
    Output : true
    Input : 152: 1^3 + 5^3 + 3^3 = 1 + 125+ 8 = 134
    Output : false
35. Write a program to find HCF of two numbers.
    Input : 12, 144
    Output : 12
    Input : 12, 143
    Output : 1
36. Program to check if a given year is leap year
    Input : 2100
    Output : false
    Input : 1600
    Output : true
37. Program to Check if a Given String is Palindrome 
    Input : abba
    Output : true
    Input : abbc
    Output : false
38. Check given number is prime number
    Input:2, 5, 7,11
    output : True
    Input : 4,6,8, 10
    Output : false
39. Print all prime numbers less than or equal to N
40. LCM
41. HCF
42. Compute average of two numbers without overflow
43. Given a list of integers, count and return the number of times each value appears as an array of integers.
44. 

