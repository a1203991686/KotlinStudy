package leetcode.easy

import leetcode.TreeNode

/**
 * 235. 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @author littlecorgi
 * @date 2020/9/27
 */
fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null || p == null || q == null) {
        return null
    }
    val result = ArrayList<ArrayList<TreeNode>>()
    val path = ArrayList<TreeNode>()
    findPath(root, path, result, p, q)
    val pPath = result[0]
    val qPath = result[1]
    val n = if (pPath.size > qPath.size) qPath.size else pPath.size
    var commonNode = TreeNode()
    for (i in 0 until n) {
        if (pPath[i].`val` == qPath[i].`val`) {
            commonNode = pPath[i]
            continue
        } else {
            break
        }
    }
    return commonNode
}

private fun findPath(
    root: TreeNode?,
    path: ArrayList<TreeNode>,
    result: ArrayList<ArrayList<TreeNode>>,
    p: TreeNode?,
    q: TreeNode?
) {
    if (root == null) {
        return
    }
    if (result.size == 2) {
        return
    }
    path.add(root)
    if (p != null && root.`val` == p.`val`) {
        result.add(ArrayList(path))
    }
    if (q != null && root.`val` == q.`val`) {
        result.add(ArrayList(path))
    }
    if (root.left != null) {
        findPath(root.left, path, result, p, q)
    }
    if (root.right != null) {
        findPath(root.right, path, result, p, q)
    }
    path.remove(root)
}