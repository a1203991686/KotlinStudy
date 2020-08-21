package leetcode

import kotlin.reflect.jvm.internal.impl.utils.DFS

/**
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
class TreeNode() {
    constructor(a: Int) : this() {
        this.`val` = a
    }

    var `val`: Int = 0
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}

/**
 * 返回如下一棵二叉树
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
fun getBinaryTree(): TreeNode {
    val root = TreeNode(3)
    val a = TreeNode(9)
    val b = TreeNode(20)
    val c = TreeNode(15)
    val d = TreeNode(7)
    root.left = a
    root.right = b
    b.left = c
    b.right = d
    return root
}