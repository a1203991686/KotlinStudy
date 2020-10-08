package leetcode.tencent.array_string

/**
 * 反转字符串
 * https://leetcode-cn.com/leetbook/read/tencent/xxj50s/
 * @author littlecorgi
 * @date 2020/10/8
 */
fun reverseString(s: CharArray): Unit {
    var l = 0
    var r = s.size - 1
    while (l < r) {
        swap(s, l, r)
        l++
        r--
    }
}

private fun swap(s: CharArray, i: Int, j: Int) {
    val temp = s[i]
    s[i] = s[j]
    s[j] = temp
}
