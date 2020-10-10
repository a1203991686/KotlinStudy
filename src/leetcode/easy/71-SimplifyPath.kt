package leetcode.easy

import java.util.*
import java.util.regex.Pattern

/**
 * 71. 简化路径
 * https://leetcode-cn.com/problems/simplify-path/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun simplifyPath(path: String): String {
    val stack = Stack<String>()
    val pathArray = path.substring(1, path.length).split(Pattern.compile("/+"))
    for (i in pathArray) {
        if (i == "." || i == "") {
            continue
        } else if (i == "..") {
            if (stack.isNotEmpty()) {
                stack.pop()
            }
        } else {
            stack.push(i)
        }
    }
    return stack.join("/")
}

fun <T> Stack<T>.join(str: String): String {
    if (this.isEmpty()) {
        return "/"
    }
    val sb = StringBuilder()
    for (i in this) {
        sb.append("/${i}")
    }
    return sb.toString()
}