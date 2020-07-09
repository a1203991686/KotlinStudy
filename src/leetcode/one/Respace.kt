package leetcode.one

import java.util.*
import kotlin.collections.HashSet

/**
 * 面试题 17.13. 恢复空格
 * https://leetcode-cn.com/problems/re-space-lcci/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 *
 * 注：此代码存在问题，正确解答看官方题解
 */
class Respace {

    companion object {
        private const val P = Int.MAX_VALUE
        private const val BASE = 41
    }

    fun respace(dictionary: Array<String>, sentence: String): Int {
        val hashValues = HashSet<Long>()
        for (word in dictionary) {
            hashValues.add(getHash(word))
        }

        val f = IntArray(sentence.length + 1)
        Arrays.fill(f, sentence.length)

        f[0] = 0
        for (i in 1..sentence.length) {
            f[i] = f[i - 1] + 1
            var hashValue = 0L
            for (j in i until 1) {
                val t = sentence[j - 1] - 'a' + 1
                hashValue = (hashValue * BASE + t) % P
                if (hashValues.contains(hashValue)) {
                    f[i] = Math.min(f[i], f[j - 1])
                }
            }
        }
        return f[sentence.length]
    }

    private fun getHash(s: String): Long {
        var hashValue = 0L
        for (i in s.length - 1 until 0) {
            hashValue = (hashValue * BASE + (s[i] - 'a' + 1).toLong()) % P
        }
        return hashValue
    }
}