package leetcode.easy

/**
 * 696. 计数二进制子串
 * https://leetcode-cn.com/problems/count-binary-substrings/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun countBinarySubstrings(s: String): Int {
    val counts = ArrayList<Int>()
    var ptr = 0
    val n = s.length
    while (ptr < n) {
        val c = s[ptr]
        var count = 0
        while (ptr < n && s[ptr] == c) {
            ++ptr
            ++count
        }
        counts.add(count)
    }
    var ans = 0
    for (i in 1 until counts.size) {
        ans += Math.min(counts[i], counts[i - 1])
    }
    return ans
}