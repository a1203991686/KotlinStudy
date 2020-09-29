package leetcode.one

import leetcode.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * 145. 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * @author littlecorgi
 * @date 2020/9/29
 */
fun postorderTraversal(root: TreeNode?): List<Int> {
    val result = ArrayList<Int>()
    val stack = LinkedList<TreeNode>()
    var temp = root
    var prev: TreeNode? = null
    while (temp != null || stack.isNotEmpty()) {
        while (temp != null) {
            stack.push(temp)
            temp = temp.left
        }
        temp = stack.pop()
        if (temp.right == null || temp.right == prev) {
            result.add(temp.`val`)
            prev = temp
            temp = null
        } else {
            stack.push(temp)
            temp = temp.right
        }
    }
    // back(root, result)
    return result
}

private fun back(root: TreeNode?, result: ArrayList<Int>) {
    if (root == null) {
        return
    }
    if (root.left != null) {
        back(root.left, result)
    }
    if (root.right != null) {
        back(root.right, result)
    }
    result.add(root.`val`)
}
