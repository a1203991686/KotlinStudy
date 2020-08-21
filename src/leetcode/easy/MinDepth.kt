package leetcode.easy

import leetcode.TreeNode

/**
 * 111. 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun minDepth(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    if (root.left == null && root.right == null) {
        return 1
    }

    var minHeight = Int.MAX_VALUE
    if (root.left != null) {
        minHeight = Math.min(minDepth(root.left), minHeight)
    }
    if (root.right != null) {
        minHeight = Math.min(minDepth(root.right), minHeight)
    }
    return minHeight + 1
}
