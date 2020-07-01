package leetcode.one

/**
 * 718. 最长重复子数组
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun findLength(A: IntArray, B: IntArray): Int {
    val n = A.size
    val m = B.size
    val dp = Array(n + 1) {
        IntArray(m + 1)
    }
    var ans = 0
    for (i in n - 1 downTo 0) {
        for (j in m - 1 downTo 0) {
            dp[i][j] = if (A[i] == B[j]) dp[i + 1][j + 1] + 1 else 0
            ans = Math.max(ans, dp[i][j])
        }
    }
    return ans
}