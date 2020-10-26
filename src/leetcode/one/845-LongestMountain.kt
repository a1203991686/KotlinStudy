package leetcode.one

/**
 * 845. 数组中的最长山脉
 * https://leetcode-cn.com/problems/longest-mountain-in-array/
 * @author littlecorgi
 * @date 2020/10/25
 */
fun longestMountain(A: IntArray): Int {
    val n = A.size
    var result = 0
    if (n < 3) {
        return result
    }
    val left = IntArray(n)
    for (i in 1 until n) {
        left[i] = if (A[i - 1] < A[i]) left[i - 1] + 1 else 0
    }
    val right = IntArray(n)
    for (i in n - 2 downTo 0) {
        right[i] = if (A[i + 1] < A[i]) right[i + 1] + 1 else 0
    }
    var ans = 0
    for (i in A.indices) {
        if (left[i] > 0 && right[i] > 0) {
            ans = Math.max(ans, left[i] + right[i] + 1)
        }
    }
    return ans
}
