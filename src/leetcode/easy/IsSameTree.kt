package leetcode.easy

import leetcode.TreeNode
import java.util.*

/**
 * 100. 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) {
        return true
    } else if (p == null || q == null) {
        return false
    }
    val queue1 = LinkedList<TreeNode>()
    val queue2 = LinkedList<TreeNode>()
    queue1.offer(p)
    queue2.offer(q)
    while (queue1.isNotEmpty() && queue2.isNotEmpty()) {
        val node1 = queue1.poll()
        val node2 = queue2.poll()
        if (node1.`val` != node2.`val`) {
            return false
        }
        val left1 = node1.left
        val right1 = node1.right
        val left2 = node2.left
        val right2 = node2.right
        if ((left1 == null).xor(left2 == null)) {
            return false
        }
        if ((right1 == null).xor(right2 == null)) {
            return false
        }
        if (left1 != null) {
            queue1.offer(left1)
        }
        if (left2 != null) {
            queue2.offer(left2)
        }
        if (right1 != null) {
            queue1.offer(right1)
        }
        if (right2 != null) {
            queue2.offer(right2)
        }
    }
    return queue1.isEmpty() && queue2.isEmpty()
}