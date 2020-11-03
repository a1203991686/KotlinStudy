package leetcode.easy

/**
 * 941. 有效的山脉数组
 * https://leetcode-cn.com/problems/valid-mountain-array/
 * @author littlecorgi
 * @date 2020/11/3
 */
fun validMountainArray(A: IntArray): Boolean {
    if (A.size <= 1) return false
    if (A[1] <= A[0]) return false
    // 代表递增或递减的标志
    var tag = true
    for (i in 1 until A.size) {
        // 递增，并且当前比上一位大，则继续
        if (tag && A[i] > A[i - 1]) {
            continue
        }
        // 递增，并且当前和上一位相等，则返回失败
        if (tag && A[i] == A[i - 1]) {
            return false
        }
        // 递增，但是当前比上一位小，就转换为递减
        if (tag && A[i] < A[i - 1]) {
            tag = false
            continue
        }
        // 递减，并且当前比上一位小，则继续
        if (!tag && A[i] < A[i - 1]) {
            continue
        }
        // 递减，并且当前和上一位相等，则返回失败
        if (!tag && A[i] == A[i - 1]) {
            return false
        }
        // 递减，并且当前比上一位大，则返回失败
        if (!tag && A[i] > A[i - 1]) {
            return false
        }
    }
    return !tag
}
