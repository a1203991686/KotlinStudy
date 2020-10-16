package leetcode.tencent.math

/**
 * 回文数
 * https://leetcode-cn.com/leetbook/read/tencent/x54pet/
 * @author littlecorgi
 * @date 2020/10/16
 */
/*
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
示例 1:
输入: 121
输出: true
示例 2:
输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:
输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
fun isPalindrome(x: Int): Boolean {
    if (x < 0) return false
    for (i in 0..100) {
        val temp1 = x / Math.pow(10.0, i.toDouble())
    }
    return true
}

fun main() {

}