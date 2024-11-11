package trieTree

/*
Create a function boolean startsWith(String prefix) for a trie.
Return true if there is a previously inserted string word that has the prefix, and false otherwise
words[] ={"apple","app","mango","man","woman"}
prefix = "app"  output: true
prefix = "moon" output: false
*/

class TrieStart{
    var NodeTrie: Array<TrieStart?> = arrayOfNulls(26)
}

var rootStart = TrieStart()
fun insertTrieStart(word: String){
    var current = rootStart
    for (i in 0.. word.length-1){
        var index = word[i] - 'a'
        if (current.NodeTrie[index] == null) current.NodeTrie[index] = TrieStart()
        current = current.NodeTrie[index]!!
    }

}

fun startWith(word: String): Boolean{
    var current = rootStart
    for (i in 0.. word.length-1){
        var index = word[i] - 'a'
        if (current.NodeTrie[index] == null) return false
        current = current.NodeTrie[index]!!
    }
    return true
}

fun main(){
    var list = arrayListOf("apple","app","mango","man","woman")
    var prefix = "moon"
    list.forEach{ insertTrieStart(it) }
    println(startWith(prefix))
}