package leetcode.easy

import leetcode.TreeNode

/**
 * 404. 左叶子之和
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 * @author littlecorgi
 * @date 2020/9/19
 */
fun sumOfLeftLeaves(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    var result = 0
    if (root.left != null && root.left?.left == null && root.left?.right == null) {
        result = root.left?.`val`!!
    }
    return result + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right)
}
