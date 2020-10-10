package leetcode.easy

import kotlin.math.max

/**
 * 1014. 最佳观光组合
 * https://leetcode-cn.com/problems/best-sightseeing-pair/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 *
 * 纯智力题，意义不大
 */
fun maxScoreSightseeingPair(A: IntArray): Int {
    if (A.isEmpty()) {
        return 0
    }
    var ans = 0
    var mx = A[0] + 0
    for (i in 1 until A.size) {
        ans = max(ans, mx + A[i] - i)
        mx = max(mx, A[i] + i)
    }
    return ans
}