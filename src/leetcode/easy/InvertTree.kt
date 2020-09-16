package leetcode.easy

import leetcode.TreeNode

/**
 * 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * @author littlecorgi
 * @date 2020/9/16
 */
fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    val left = invertTree(root.left)
    val right = invertTree(root.right)
    root.left = right
    root.right = left
    return root
}