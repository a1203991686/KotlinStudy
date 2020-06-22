package leetcode

/**
 * 93. 复原IP地址
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun restoreIpAddresses(s: String): List<String> {
    val a = s.length / 4

    val s1 = StringBuilder()
    val s2 = StringBuilder()
    val s3 = StringBuilder()
    val s4 = StringBuilder()

    for (i in s.indices) {
        s1.append(s[i])
        if (s.length - i > 4 * 3) {
            break
        }
    }
    return emptyList()
}

fun main() {
    println(restoreIpAddresses("25525511135"))
}