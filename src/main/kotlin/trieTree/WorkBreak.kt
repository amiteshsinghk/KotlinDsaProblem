package trieTree

/*
* Given an input string and a dictionary of word, find out if the input string can be broken into a space- seperated sequence of dictionary word.
*  words[] = arrayOf("i", "like", "sam","samsung","mobile","ice")
*  key = "ilikesamsung"
*  output: true
* */

class TrieTree{
    class TrieNode(){
        var Node : Array<TrieNode?> = arrayOfNulls(26)
        var eow: Boolean = false
    }
}

 val rootTrie = TrieTree.TrieNode()

fun insertTrieTreeData(word: String){
    var current = rootTrie
    word.forEachIndexed { i, c ->
       var index = word[i] -'a'
        if (current.Node[index] == null){
            current.Node[index] = TrieTree.TrieNode()
        }
        if (i == word.length-1) current.eow = true
        current = current.Node[index]!!
    }
}

fun searchTrieTreeData(word: String): Boolean{
    var current = rootTrie
    word.forEachIndexed { i, c ->
        var index = word[i] - 'a'
        if (current.Node[index] == null){
            return false
    }
        if(i == word.length-1 && current.eow == false){
            return false
        }
        current = current.Node[index]!!
    }
    return true
}

fun wordBreak( key: String): Boolean{
    if (key.length ==0){
        return true
    }
    key.forEachIndexed { index, c ->
        var firstStr = key.substring(0,index+1)// substring(0, index + 1) extracts a substring from the start of the string (index 0) up to
        // (but not including) the character at index + 1, effectively returning the substring from the start of the string to the index position
        var secondStr= key.substring(index+1)// substring(index + 1) extracts a substring starting from the character right after index (i.e., index + 1) to the end of the string
        if (searchTrieTreeData(firstStr) && wordBreak(secondStr)) return true
    }
    return false
}

fun main() {
    val word = arrayOf("i","like","samsung","sam","mobile")
    word.forEachIndexed { _, s ->
        insertTrieTreeData(s)
    }
    println(wordBreak("ilikesamsung"))
}