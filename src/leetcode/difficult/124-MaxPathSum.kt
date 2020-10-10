package leetcode.difficult

import leetcode.TreeNode

/**
 * 124. 二叉树中的最大路径和
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
var maxSum = Int.MIN_VALUE

fun maxPathSum(root: TreeNode?): Int {
    maxGain(root)
    return maxSum
}

fun maxGain(node: TreeNode?): Int {
    if (node == null) {
        return 0
    }

    val leftGain = Math.max(maxGain(node.left), 0)
    val rightGain = Math.max(maxGain(node.right), 0)

    val priceNewPath = node.`val` + leftGain + rightGain

    maxSum = Math.max(maxSum, priceNewPath)

    return node.`val` + Math.max(leftGain, rightGain)
}