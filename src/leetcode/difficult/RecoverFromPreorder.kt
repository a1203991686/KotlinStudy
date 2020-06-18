package leetcode.difficult

import leetcode.TreeNode

/**
 * 1028. 从先序遍历还原二叉树
 * https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun recoverFromPreorder(S: String): TreeNode? {
    if (S.isEmpty()) {
        return null
    }
    val hashmap = HashMap<Int, Int>()
    val root = TreeNode(S[0].toNumberInt())
    var desCount = 0

    return root
}

fun Char.toNumberInt(): Int {
    return this.toInt() - '0'.toInt()
}