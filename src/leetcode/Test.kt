package leetcode

import java.util.*
import kotlin.collections.ArrayList

/**
 *
 * @author littlecorgi
 * @date 2020/10/27
 */
fun preorderTraversal(root: TreeNode?): List<Int> {
    val stack = LinkedList<TreeNode>()
    var temp = root
    val result = ArrayList<Int>()
    while (stack.isNotEmpty() || temp != null) {
        while (temp != null) {
            result.add(temp.`val`)
            stack.push(temp)
            temp = temp.left
        }
        temp = stack.pop()
        temp = temp.right
    }
    return result
}

fun main() {
    val a = TreeNode(1)
    val b = TreeNode(2)
    val c = TreeNode(3)
    a.right = b
    b.left = c
    val result = preorderTraversal(a)
    println(result)
}