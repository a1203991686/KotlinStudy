package leetcode.easy

import java.util.*

/**
 * 392. 判断子序列
 * https://leetcode-cn.com/problems/is-subsequence/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun isSubsequence(s: String, t: String): Boolean {
    val stack = LinkedList<Char>()
    for (i in s) {
        stack.add(i)
    }
    for (j in t) {
        if (stack.peek() == j) {
            stack.pop()
        }
    }
    return stack.isEmpty()
}
