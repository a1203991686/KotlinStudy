package leetcode.easy

import leetcode.TreeNode

/**
 * 617. 合并二叉树
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 * @author littlecorgi
 * @date 2020/9/23
 */
fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
    if (t1 == null) {
        return t2
    }
    if (t2 == null) {
        return t1
    }
    val newNode = TreeNode(t1.`val` + t2.`val`)
    newNode.left = mergeTrees(t1.left, t2.left)
    newNode.right = mergeTrees(t1.right, t2.right)
    return newNode
}