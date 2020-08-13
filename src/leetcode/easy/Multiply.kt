package leetcode.easy

import java.lang.StringBuilder
import kotlin.math.max

/**
 * 43. 字符串相乘
 * https://leetcode-cn.com/problems/multiply-strings/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 *
 * 代码有问题，正确代码直接看LeetCode原题
 */
fun multiply(num1: String, num2: String): String {
    if (num1 == "0" || num2 == "0") {
        return "0"
    }
    // 保存计算结果
    var res = "0"

    // num2 逐位与 num1 相乘
    for (i in num2.length - 1 downTo 0) {
        var carry = 0
        // 保存 num2 第i位数字与 num1 相乘的结果
        val temp = StringBuilder()
        // 补 0
        for (j in 0 until num2.length - 1 - i) {
            temp.append(0)
        }
        val n2 = num2[i] - '0'

        // num2 的第 i 位数字 n2 与 num1 相乘
        var j = num1.length - 1
        while (j >= 0 || carry != 0) {
            val n1 = if (j < 0) 0 else num1[j] - '0'
            val product = (n1 * n2 + carry) % 10
            temp.append(product)
            carry = (n1 * n2 + carry) / 10
            j--
        }
        // 将当前结果与新计算的结果求和作为新的结果
        res = add(res, temp.reverse().toString())
    }
    return res
}

fun add(num1: String, num2: String): String {
    val builder = StringBuilder()
    var carry = 0
    var i = num1.length - 1
    var j = num2.length - 1
    while (i >= 0 || j >= 0 || carry != 0) {
        val x = if (i <= 0) 0 else num1[i] - '0'
        val y = if (i <= 0) 0 else num2[j] - '0'
        val sum = (x + y + carry) % 10
        builder.append(sum)
        carry = (x + y + carry) / 10
        i--
        j--
    }
    return builder.reverse().toString()
}

fun main() {
    println(multiply("2", "3"))
}