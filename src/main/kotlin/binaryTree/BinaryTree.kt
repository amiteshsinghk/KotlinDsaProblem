package binaryTree

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
fun preorderTransversal(root: NodeBt?) {
    if (root == null) {
        return
    }
    print("${root.data} ")
    preorderTransversal(root.left)
    preorderTransversal(root.right)
}

// DFS -> Depth search property
// LeftSubtree ->Root -> RightSubtree
// Time Complexity O(n)
fun inorderTraversal(root: NodeBt?) {
    if (root == null) return
    inorderTraversal(root.left)
    print("${root.data} ")
    inorderTraversal(root.right)
}

// DFS -> Depth search property
//leftSubtree -> RightSubtree -> Root
// Time Complexity O(n)
fun postorderTraversal(root: NodeBt?) {
    if (root == null) return
    postorderTraversal(root.left)
    postorderTraversal(root.right)
    print("${root.data} ")

}

// BFS -> Breadth search property
// In level order we print the node at the same level
// Time Complexity O(n)
fun levelOrderTraversal(root: NodeBt?) {
    val q: Queue<NodeBt> = LinkedList()
    q.add(root)
    q.add(null)
    while (!q.isEmpty()) {
        val current = q.remove()
        if (current == null) {
            println()
            if (q.isEmpty()) {
                break
            } else {
                q.add(null)
            }
        } else {
            print("${current.data} ")
            if (current.left != null) {
                q.add(current.left)
            }
            if (current.right != null) {
                q.add(current.right)
            }
        }
    }

}

// Time Complexity O(n)
fun countOfNodes(nodeBt: NodeBt?): Int {
    if (nodeBt == null) {
        return 0
    }
    val leftCount = countOfNodes(nodeBt.left)
    val rightCount = countOfNodes(nodeBt.right)
    return leftCount + rightCount + 1
}

// Time Complexity O(n)
// coerceAtLeast is same as Math.max(item1,item2 )
fun sumOfNode(nodeBt: NodeBt?): Int {
    if (nodeBt == null) return 0
    val leftSum = sumOfNode(nodeBt.left)
    val rightSum = sumOfNode(nodeBt.right)
    return leftSum + rightSum + nodeBt.data
}

// Time Complexity O(n)
fun heightOfTree(nodeBt: NodeBt?): Int {
    if (nodeBt == null) return 0
    val leftHeight = heightOfTree(nodeBt.left)
    val rightHeight = heightOfTree(nodeBt.right)
    return leftHeight.coerceAtLeast(rightHeight) + 1
}

// Time Complexity O(n^2)
// coerceAtLeast is same as Math.max(item1,item2 )
fun diameter(nodeBt: NodeBt?): Int {
    if (nodeBt == null) return 0
    val leftDiameter = diameter(nodeBt.left)
    val rightDiameter = diameter(nodeBt.right)
    val diameter3 = heightOfTree(nodeBt.left) + heightOfTree(nodeBt.right) + 1
    return diameter3.coerceAtLeast(leftDiameter.coerceAtLeast(rightDiameter))
}

data class TreeInfo(val height: Int, val diameter: Int)

// Time Complexity O(n)
fun diameter2(nodeBt: NodeBt?): TreeInfo {
    if (nodeBt == null) return TreeInfo(0, 0)
    val left: TreeInfo = diameter2(nodeBt.left)
    val right: TreeInfo = diameter2(nodeBt.right)
    val height = left.height.coerceAtLeast(right.height) + 1

    val dia1 = left.diameter
    val dia2 = right.diameter
    val dia3 = left.height + right.height + 1
    val info = dia1.coerceAtLeast(dia2).coerceAtLeast(dia3)
    return TreeInfo(height, info)
}

fun main() {
    val listNodes = mutableListOf(1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1)
    val tree = BinaryTree()
    val root = tree.buildTree(listNodes)
    println(root?.data)
    preorderTransversal(root)
    println()
    inorderTraversal(root)
    println()
    postorderTraversal(root)
    println()
    levelOrderTraversal(root)
    println()
    println("Count of nodes :: ${countOfNodes(root)}")
    println("Sum of nodes :: ${sumOfNode(root)}")
    println("Height of tree ${heightOfTree(root)}")
    println("Diameter of tree ${diameter(root)}")
    println("Diameter of tree2 ::  ${diameter2(root)}")
}

/*
* Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the
* same structure and node values of subRoot and false otherwise.
* A subtree of a binary tree is a tree that consists of a node in tree and all of this node's descendants.
* The tree could also be considered as a subtree of itself.
* */
fun isIdentical(root: NodeBt?, subRoot: NodeBt?): Boolean {
    if (subRoot == null && root == null) return true
    if (subRoot == null || root == null) return false
    if (subRoot.data == root.data) return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right)
    return false
}

fun isSubtree(root: NodeBt?, subRoot: NodeBt?): Boolean {
    if (subRoot == null) return true
    if (root == null) return false
    if (root.data == subRoot.data) {
        if (isIdentical(root, subRoot)) return true
    }
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)

}