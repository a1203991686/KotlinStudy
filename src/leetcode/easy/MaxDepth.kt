package leetcode.easy

import leetcode.TreeNode
import java.util.*

/**
 * 104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun maxDepth(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    val stack = Stack<Pair<TreeNode, Int>>()
    var result = 0
    stack.add(Pair(root, 1))
    while (stack.isNotEmpty()) {
        val (tempNode, pile) = stack.pop()
        if (tempNode.left == null && tempNode.right == null) {
            result = Math.max(result, pile)
        } else if (tempNode.left != null && tempNode.right == null) {
            stack.add(Pair(tempNode.left!!, pile + 1))
        } else if (tempNode.left == null && tempNode.right != null) {
            stack.add(Pair(tempNode.right!!, pile + 1))
        } else {
            stack.add(Pair(tempNode.left!!, pile + 1))
            stack.add(Pair(tempNode.right!!, pile + 1))
        }
    }
    return result
}
