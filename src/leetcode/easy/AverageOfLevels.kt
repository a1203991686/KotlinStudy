package leetcode.easy

import leetcode.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * 637. 二叉树的层平均值
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun averageOfLevels(root: TreeNode?): DoubleArray {
    if (root == null) {
        return doubleArrayOf(0.0)
    }
    val resultList = ArrayList<Double>()
    val queue = LinkedList<TreeNode?>()
    queue.offer(root)
    while (queue.isNotEmpty()) {
        var tempResult = 0.0
        var size = 0
        // 取出当前这一层的元素
        val tempSize = queue.size
        for (i in 0 until tempSize) {
            val temp = queue.poll()
            if (temp != null) {
                tempResult += temp.`val`
                size++
                if (temp.left != null) {
                    queue.offer(temp.left)
                }
                if (temp.right != null) {
                    queue.offer(temp.right)
                }
            }
        }
        resultList.add(tempResult / size)
    }
    return resultList.toDoubleArray()
}
