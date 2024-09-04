package BinaryTree

import org.w3c.dom.Node
import java.util.*


data class NodeBt(val data: Int, var left: NodeBt? = null, var right: NodeBt? = null)
class BinaryTree {
    var index = -1
    fun buildTree(list: MutableList<Int>): NodeBt? {
        index++
        if (list[index] == -1) return null
        val newNode = NodeBt(list[index])
        newNode.left = buildTree(list)
        newNode.right = buildTree(list)
        return newNode
    }
}
// DFS -> Depth search property
// Root -> leftSubtree -> RightSubtree
// Time Complexity O(n)
fun preorderTransversal(root: NodeBt?){
    if (root == null) {
        return
    }
    print("${ root.data } ")
    preorderTransversal(root.left)
    preorderTransversal(root.right)
}
// DFS -> Depth search property
// LeftSubtree ->Root -> RightSubtree
// Time Complexity O(n)
fun inorderTraversal(root: NodeBt?){
    if (root == null) return
    inorderTraversal(root.left)
    print("${root.data} ")
    inorderTraversal(root.right)
}

// DFS -> Depth search property
//leftSubtree -> RightSubtree -> Root
// Time Complexity O(n)
fun postorderTraversal(root: NodeBt?){
    if (root == null) return
    postorderTraversal(root.left)
    postorderTraversal(root.right)
    print("${root.data} ")

}

// BFS -> Breadth search property
// In level order we print the node at the same level
// Time Complexity O(n)
fun levelorderTraversal(root: NodeBt?){
    val q: Queue<NodeBt> = java.util.LinkedList()
    q.add(root)
    q.add(null)
    while (!q.isEmpty()){
        val current = q.remove()
        if (current == null){
            println()
            if (q.isEmpty()){
                break
            }else{
                q.add(null)
            }
        }else{
            print("${current.data} ")
            if (current.left != null){
                q.add(current.left)
            }
            if (current.right != null){
                q.add(current.right)
            }
        }
    }

}

// Time Complexity O(n)
fun countOfNodes(nodeBt: NodeBt?): Int{
    if (nodeBt == null){
        return 0
    }
    var leftCount = countOfNodes(nodeBt?.left)
    var rightCount = countOfNodes(nodeBt?.right)
    return leftCount + rightCount + 1
}

fun sumOfNode(nodeBt: NodeBt?): Int{
    if (nodeBt == null) return 0
    var leftSum = sumOfNode(nodeBt?.left)
    var rightSum = sumOfNode(nodeBt?.right)
    return leftSum + rightSum + nodeBt.data
}



fun main() {
    val listNodes = mutableListOf<Int>(1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1)
    val tree = BinaryTree()
    val root = tree.buildTree(listNodes)
    println(root?.data)
    preorderTransversal(root)
    println()
    inorderTraversal(root)
    println()
    postorderTraversal(root)
    println()
    levelorderTraversal(root)
    println()
    println("Count of nodes :: ${countOfNodes(root)}")
    println("Sum of nodes :: ${sumOfNode(root)}")
}