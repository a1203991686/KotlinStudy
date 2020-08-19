package leetcode.one

/**
 * 647. 回文子串
 * https://leetcode-cn.com/problems/palindromic-substrings/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun countSubstrings(s: String): Int {
    val n = s.length
    var ans = 0
    for (i in 0 until 2 * n - 1) {
        var l = i / 2
        var r = i / 2 + i % 2
        while (l >= 0 && r < n && s[l] == s[r]) {
            --l
            ++r
            ++ans
        }
    }
    return ans
}