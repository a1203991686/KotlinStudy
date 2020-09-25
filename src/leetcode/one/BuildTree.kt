package leetcode.one

import leetcode.TreeNode

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @author littlecorgi
 * @date 2020/9/25
 */
private var post_idx = 0
private lateinit var mPostorder: IntArray
private lateinit var mInorder: IntArray
private val idx_map = HashMap<Int, Int>()

fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
    mPostorder = postorder
    mInorder = inorder
    post_idx = postorder.size - 1
    var idx = 0
    for (v in inorder) {
        idx_map[v] = idx++
    }
    return helper(0, inorder.size - 1)
}

private fun helper(in_left: Int, in_right: Int): TreeNode? {
    if (in_left > in_right) {
        return null
    }
    val rootVal = mPostorder[post_idx]
    val root = TreeNode(rootVal)

    val index = idx_map[rootVal] ?: 0

    post_idx--
    root.right = helper(index + 1, in_right)
    root.left = helper(in_left, index - 1)
    return root
}
