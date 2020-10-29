package leetcode.easy

import leetcode.TreeNode

/**
 * 129. 求根到叶子节点数字之和
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * @author littlecorgi
 * @date 2020/10/29
 */
fun sumNumbers(root: TreeNode?): Int {
    val arrayList = ArrayList<Int>()
    root?.let { dfs(root, arrayList, StringBuilder()) }
    return if (arrayList.isEmpty()) {
        0
    } else {
        var result = 0
        for (i in arrayList) {
            result += i
        }
        result
    }
}

fun dfs(root: TreeNode, arrayList: ArrayList<Int>, sum: StringBuilder) {
    val tempSum = sum.append(root.`val`)
    if (root.left == null && root.right == null) {
        arrayList.add(tempSum.toString().toInt())
    }
    root.left?.let {
        dfs(it, arrayList, tempSum)
    }
    root.right?.let {
        dfs(it, arrayList, tempSum)
    }
    tempSum.deleteCharAt(tempSum.lastIndex)
}
