package leetcode.easy

import leetcode.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * 144. 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun preorderTraversal(root: TreeNode?): List<Int> {
    val output = ArrayList<Int>()
    val stack = Stack<TreeNode>()
    var temp = root
    while (temp != null) {
        output.add(temp.`val`)
        if (temp.right != null) {
            stack.push(temp.right)
        }
        temp = if (temp.left != null) {
            temp.left
        } else {
            if (stack.isNotEmpty()) stack.pop() else break
        }
    }
    return output
}