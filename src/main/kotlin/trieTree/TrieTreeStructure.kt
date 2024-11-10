package trieTree

class TrieTreeStructure {

    class Node{
        var children: Array<Node?> = arrayOfNulls(26)
        var eow: Boolean = false

    }
}

var root = TrieTreeStructure.Node()
fun insertTrieTree(word: String){
    var current = root
   for (i in word.indices){
       // this will give the index of current letter
       val index = word[i]-'a'
       // If the current index of node is null than add a new node
       if (current.children.get(index) == null){
           //add new Node
           current.children[index] = TrieTreeStructure.Node()
       }
        // we need to make the eow of last node of word true, So that we know, word is ended here.
       if (i == word.length-1){
           current.children[index]?.eow = true
       }
       current = current.children[index]!!
   }
}

fun searchTrieTree(word: String): Boolean{
    var current = root
    for (i in word.indices){
        val index = word[i] - 'a'
        if (current.children[index] == null) return false
        if ((i == word.length-1) && current.children[index]?.eow == false) {
            return false

        }
        current = current.children[index]!!
    }
    return true
}

fun main(){
    val word = arrayOf("the", "their","a", "there","any")
    word.forEachIndexed { _, s ->
        insertTrieTree(s)
    }
    println(searchTrieTree("there"))
    println(searchTrieTree("ere"))
    println(searchTrieTree("the"))
    println(searchTrieTree("ab"))
}