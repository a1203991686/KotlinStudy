package leetcode

import kotlin.reflect.jvm.internal.impl.utils.DFS

/**
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}