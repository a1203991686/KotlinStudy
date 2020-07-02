package leetcode

/**
 * 378. 有序矩阵中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/submissions/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
    val n = matrix.size
    var left = matrix[0][0]
    var right = matrix[n - 1][n - 1]
    while (left < right) {
        val mid = left + ((right - left).shr(1))
        if (check(matrix, mid, k, n)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

fun check(matrix: Array<IntArray>, mid: Int, k: Int, n: Int): Boolean {
    var i = n - 1
    var j = 0
    var num = 0
    while (i >= 0 && j < n) {
        if (matrix[i][j] <= mid) {
            num += i + 1
            j++
        } else {
            i--
        }
    }
    return num >= k
}