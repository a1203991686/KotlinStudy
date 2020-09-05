package leetcode

import java.lang.StringBuilder
import java.util.*

/**
 * 60. 第k个排列
 * https://leetcode-cn.com/problems/permutation-sequence/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun getPermutation(n: Int, k: Int): String {
    var tempN = n
    var tempK = k
    val factorial = IntArray(n)
    factorial[0] = 1
    for (i in 1 until n) {
        factorial[i] = factorial[i - 1] * i
    }

    --tempK
    val ans = StringBuilder()
    val valid = IntArray(n + 1)
    Arrays.fill(valid, 1)
    for (i in 1..n) {
        var order = tempK / factorial[n - i] + 1
        for (j in 1..n) {
            order -= valid[j]
            if (order == 0) {
                ans.append(j)
                valid[j] = 0
                break
            }
        }
        tempK %= factorial[n - i]
    }
    return ans.toString()
}