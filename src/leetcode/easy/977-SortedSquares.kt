package leetcode.easy

/**
 * 977. 有序数组的平方
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * @author littlecorgi
 * @date 2020/10/16
 */
fun sortedSquares(A: IntArray): IntArray {
    val n = A.size
    var negative = -1
    for (i in 0 until n) {
        if (A[i] < 0) {
            negative = i
        } else {
            break
        }
    }

    val ans = IntArray(n)
    var index = 0
    var i = negative
    var j = negative + 1
    while (i >= 0 || j < n) {
        when {
            i < 0 -> {
                ans[index] = A[j] * A[j]
                j++
            }
            j == n -> {
                ans[index] = A[i] * A[i]
                i--
            }
            A[i] * A[i] < A[j] * A[j] -> {
                ans[index] = A[i] * A[i]
                i--
            }
            else -> {
                ans[index] = A[j] * A[j]
                j++
            }
        }
        index++
    }
    return ans
}
