package leetcode.difficult

import leetcode.TreeNode

/**
 * 337. 打家劫舍 III
 * https://leetcode-cn.com/problems/house-robber-iii/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun rob(root: TreeNode?): Int {
    val rootStatus = dfs(root)
    return Math.max(rootStatus[0], rootStatus[1])
}

fun dfs(node: TreeNode?): IntArray {
    if (node == null) {
        return intArrayOf(0, 0)
    }
    val l = dfs(node.left)
    val r = dfs(node.right)
    val selected = node.`val` + l[1] + r[1]
    val notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1])
    return intArrayOf(selected, notSelected)
}