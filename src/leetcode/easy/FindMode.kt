package leetcode.easy

import leetcode.TreeNode

/**
 * 501. 二叉搜索树中的众数
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * @author littlecorgi
 * @date 2020/9/24
 */
private val hashMap = HashMap<Int, Int>()
fun findMode(root: TreeNode?): IntArray {
    val ans = ArrayList<Int>()
    dfs(root)
    val it = hashMap.iterator()
    var max = 0
    while (it.hasNext()) {
        val temp = it.next()
        if (temp.value == max) {
            ans.add(temp.key)
        } else if (temp.value > max) {
            ans.clear()
            ans.add(temp.key)
            max = temp.value
        }
    }
    return ans.toIntArray()
}

private fun dfs(root: TreeNode?) {
    if (root == null) {
        return
    }
    if (hashMap.containsKey(root.`val`)) {
        hashMap[root.`val`] = hashMap[root.`val`]!!.plus(1)
    } else {
        hashMap[root.`val`] = 1
    }
    dfs(root.left)
    dfs(root.right)
}