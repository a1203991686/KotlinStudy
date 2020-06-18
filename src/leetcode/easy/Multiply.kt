package leetcode.easy

import java.lang.StringBuilder
import kotlin.math.max

/**
 * 43. 字符串相乘
 * https://leetcode-cn.com/problems/multiply-strings/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 *
 * 可优化，此题放入leetcode会编译超时
 * 优化方案也很简单，直接模拟列式乘法，对于每一位的乘法作加法处理
 */
fun multiply(num1: String, num2: String): String {
    if (num1 == "0" || num2 == "0") {
        return "0"
    }
    var result = "0"
    repeat(num2.toInt()) {
        result = add(result, num1)
    }
    return result
}

fun add(num1: String, num2: String): String {
    val sb = StringBuilder()
    val maxLength = max(num1.length, num2.length)
    var addFlag = false
    var i = num1.length - 1
    var j = num2.length - 1
    var k = maxLength - 1
    while (i >= 0 && j >= 0) {
        val temp = num1[i] + num2[j] + (if (addFlag) 1 else 0)
        if (temp <= '9') {
            addFlag = false
            sb.insert(0, temp)
        } else {
            addFlag = true
            sb.insert(0, temp - 10)
        }
        i--
        j--
        k--
    }
    val m = if (i == k) {
        i
    } else {
        j
    }
    val tempStr = if (i == k) {
        num1
    } else {
        num2
    }
    for (l in m downTo 0) {
        val temp = tempStr[l] + (if (addFlag) 1 else 0)
        if (temp <= '9') {
            addFlag = false
            sb.insert(0, temp)
        } else {
            addFlag = true
            sb.insert(0, temp - 10)
        }
    }
    if (addFlag) {
        sb.insert(0, '1')
    }
    return sb.toString()
}

operator fun Char.plus(b: Char): Char {
    return (this.toInt() + b.toInt() - 48).toChar()
}