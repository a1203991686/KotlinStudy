package leetcode.one

import kotlin.math.max

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun lengthOfLongestSubstring(s: String): Int {
    var length = 0
    val set = HashSet<Char>()
    var right = -1
    for (i in s.indices) {
        if (i != 0) {
            set.remove(s[i - 1])
        }
        while (right + 1 < s.length && !set.contains(s[right + 1])) {
            set.add(s[right + 1])
            right++
        }
        length = max(length, right - i + 1)
    }
    return length
}