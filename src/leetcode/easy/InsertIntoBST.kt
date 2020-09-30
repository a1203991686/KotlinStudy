package leetcode.easy

import leetcode.TreeNode

/**
 * 701. 二叉搜索树中的插入操作
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 * @author littlecorgi
 * @date 2020/9/30
 */
fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
    if (root == null) {
        return TreeNode(`val`)
    }
    var temp = root
    while (temp != null) {
        if (`val` < temp.`val`) {
            if (temp.left == null) {
                temp.left = TreeNode(`val`)
                break
            } else {
                temp = temp.left
                continue
            }
        }
        if (`val` >= temp.`val`) {
            if (temp.right == null) {
                temp.right = TreeNode(`val`)
                break
            } else {
                temp = temp.right
                continue
            }
        }
    }
    return root
}