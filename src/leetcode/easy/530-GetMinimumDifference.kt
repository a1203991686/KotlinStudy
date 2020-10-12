package leetcode.easy

import leetcode.TreeNode

/**
 * 530. 二叉搜索树的最小绝对差
 * @author littlecorgi
 * @date 2020/10/12
 */
private var pre = 0
private var ans = 0
fun getMinimumDifference(root: TreeNode?): Int {
    ans = Int.MAX_VALUE
    pre = -1
    dfs(root)
    return ans
}

private fun dfs(root: TreeNode?) {
    if (root == null) {
        return
    }
    dfs(root.left)
    if (pre == -1) {
        pre = root.`val`
    } else {
        ans = Math.min(ans, root.`val` - pre)
        pre = root.`val`
    }
    dfs(root.right)
}