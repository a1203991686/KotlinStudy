package leetcode.easy

import java.util.*
import kotlin.collections.HashMap

/**
 * 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun isValid(s: String): Boolean {
    val n = s.length
    if (n % 2 == 1) {
        return false
    }

    val pairs = HashMap<Char, Char>()
    pairs[')'] = '('
    pairs[']'] = '['
    pairs['}'] = '{'

    val stack = LinkedList<Char>()
    for (i in s.indices) {
        val ch = s[i]
        if (pairs.containsKey(ch)) {
            if (stack.isEmpty() || stack.peek() != pairs[ch]) {
                return false
            }
            stack.pop()
        } else {
            stack.push(ch)
        }
    }
    return stack.isEmpty()
}