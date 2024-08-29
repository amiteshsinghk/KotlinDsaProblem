
/*
* Find first and Last occurrence of an element in a string.
* */


    var firstElement = -1
    var secondElement = -1
    fun main() {
        firstAndLastOccurrenceOfAnElement("abaacdaefaah", 'a')
        firstAndLastOccurrenceOfAnElementRecursion("abaacdaefaah", 'a',0)
    }

    fun firstAndLastOccurrenceOfAnElementRecursion(
        item: String,
        element: Char,
        index: Int
    ) {
        if(index == item.length-1) {
            println("Recursion :: Given String is : $item. The char is \'$element\' its first occurrence is $firstElement and second is $secondElement   ")
            return
        }
        if (element == item[index]) {
            if (firstElement < 0) firstElement = index
            else secondElement = index
        }
        firstAndLastOccurrenceOfAnElementRecursion("abaacdaefaah", element, index + 1)
    }

    fun firstAndLastOccurrenceOfAnElement(item: String, element: Char) {
        var firstElement = -1
        var secondElement = -1

        for (i in item.indices) {
            if (element == item[i]) {
                if (firstElement < 0) firstElement = i
                else secondElement = i
            }
        }
        println("Given String is : $item. The char is \'$element\' its first occurrence is $firstElement and second is $secondElement")
    }