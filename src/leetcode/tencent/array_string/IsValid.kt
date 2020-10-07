package leetcode.tencent.array_string

import java.util.*

/**
 * 有效的括号
 * https://leetcode-cn.com/leetbook/read/tencent/xx1d8v/
 * @author littlecorgi
 * @date 2020/10/7
 */
fun isValid(s: String): Boolean {
    // 用来保存对应关系
    val hashMap = hashMapOf(
        ')' to '(',
        ']' to '[',
        '}' to '{'
    )
    val stack = LinkedList<Char>()
    for (i in s.indices) {
        if (s[i] == '(' || s[i] == '[' || s[i] == '{') {
            stack.push(s[i])
        } else {
            val c = s[i]
            if (stack.isEmpty()) {
                return false
            }
            if (stack.pop()
                == hashMap.getOrDefault(c, ' ')
            ) {
                continue
            } else {
                return false
            }
        }
    }
    return stack.isEmpty()
}

fun main() {
    println(isValid("]"))
}