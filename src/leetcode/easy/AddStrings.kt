package leetcode.easy

/**
 * 415. 字符串相加
 * https://leetcode-cn.com/problems/add-strings/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun addStrings(num1: String, num2: String): String {
    var i = num1.length - 1
    var j = num2.length - 1
    var add = 0
    val ans = StringBuffer()
    while (i >= 0 || j >= 0 || add != 0) {
        val x = if (i >= 0) num1[i] - '0' else 0
        val y = if (j >= 0) num2[j] - '0' else 0
        val result = x + y + add
        ans.append(result % 10)
        add = result / 10
        i--
        j--
    }
    ans.reverse()
    return ans.toString()
}