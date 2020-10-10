package leetcode.one

import leetcode.TreeNode

/**
 * 110. 平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun isBalanced(root: TreeNode?): Boolean {
    return if (root == null) {
        true
    } else {
        Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(
            root.left
        ) && isBalanced(root.right)
    }
}

fun height(root: TreeNode?): Int {
    return if (root == null) {
        0
    } else {
        Math.max(height(root.left), height(root.right)) + 1
    }
}