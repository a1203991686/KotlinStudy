package leetcode.tencent.array_string

/**
 * 最长回文子串
 * https://leetcode-cn.com/leetbook/read/tencent/xxk4s2/
 * @author littlecorgi
 * @date 2020/10/6
 */
fun longestPalindrome(s: String): String {
    val n = s.length
    if (n == 0) {
        return ""
    }
    if (n == 1) {
        return s
    }
    for (i in s.length - 1 downTo 0) {
        for (j in 0 until n - i) {
            var left = j
            var right = j + i
            // println("i=$i, j=$j, left=$left, right=$right, s=${s.substring(j, j + i + 1)}")
            var flag = true
            while (left <= right) {
                if (s[left] == s[right]) {
                    left++
                    right--
                    continue
                } else {
                    flag = false
                    break
                }
            }
            if (flag) {
                return s.substring(j, j + i + 1)
            }
        }
    }
    return ""
}
