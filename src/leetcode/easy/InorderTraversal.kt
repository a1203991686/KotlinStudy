package leetcode.easy

import leetcode.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * 94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @author littlecorgi
 * @date 2020/9/14
 */
fun inorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) {
        return ArrayList()
    }
    val stack = LinkedList<TreeNode>()
    val result = ArrayList<Int>()
    var temp = root
    while (temp != null || stack.isNotEmpty()) {
        // 遍历左子树
        while (temp != null) {
            stack.push(temp)
            temp = temp.left
        }
        temp = stack.pop()
        // 输出
        result.add(temp.`val`)
        // 遍历右节点
        temp = temp.right
    }
    return result
}
