package leetcode.easy

import leetcode.TreeNode

/**
 * 113. 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 * @author littlecorgi
 * @date 2020/9/26
 */
fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
    val result = ArrayList<ArrayList<Int>>()
    if (root == null) {
        return result
    }
    val temp = ArrayList<Int>()
    back(result, temp, root, sum)
    return result
}

private fun back(result: ArrayList<ArrayList<Int>>, temp: ArrayList<Int>, root: TreeNode, sum: Int) {
    temp.add(root.`val`)
    val sumTemp = sum - root.`val`
    if (sumTemp == 0) {
        if (root.left == null && root.right == null) {
            result.add(ArrayList(temp))
            temp.removeAt(temp.lastIndex)
            return
        }
    }

    if (root.left != null) {
        back(result, temp, root.left!!, sumTemp)
    }
    if (root.right != null) {
        back(result, temp, root.right!!, sumTemp)
    }
    temp.removeAt(temp.lastIndex)
}
