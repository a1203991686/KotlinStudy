package leetcode.one

import java.util.*

/**
 * 567. 字符串的排列
 * https://leetcode-cn.com/problems/permutation-in-string/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun checkInclusion(s1: String, s2: String): Boolean {
    val str1: String = s1.sort()
    for (i in 0 .. s2.length - s1.length) {
        if (str1 == s2.substring(i, i + s1.length).sort()) {
            return true
        }
    }
    return false
}

fun String.sort(): String {
    val a = this.toCharArray()
    Arrays.sort(a)
    return a.contentToString()
}