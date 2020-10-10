package leetcode.easy

import leetcode.TreeNode

/**
 * 112. 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
    if (root == null) {
        return false
    }
    if (root.left == null && root.right == null) {
        return sum == root.`val`
    }
    return hasPathSum(
        root.left,
        sum - root.`val`
    ) || hasPathSum(root.right, sum - root.`val`)
}