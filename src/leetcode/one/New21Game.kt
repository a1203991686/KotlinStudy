package leetcode.one

import kotlin.math.min

/**
 * 837. 新21点
 * https://leetcode-cn.com/problems/new-21-game/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun new21Game(N: Int, K: Int, W: Int): Double {
    if (K == 0) {
        return 1.0
    }
    val dp = DoubleArray(K + W)
    var i = K
    while (i <= N && i < K + W) {
        dp[i] = 1.0
        i++
    }
    dp[K - 1] = 1.0 * min(N - K + 1, W) / W
    for (j in K - 2 downTo 0) {
        dp[j] = dp[j + 1] - (dp[j + W + 1] - dp[j + 1]) / W
    }
    return dp[0]
}

fun main() {
    println(new21Game(21, 17, 10))
}