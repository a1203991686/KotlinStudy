package leetcode.tencent.array_string.review

/**
 * 螺旋矩阵
 * https://leetcode-cn.com/leetbook/read/tencent/x5elr5/
 * @author littlecorgi
 * @date 2020/10/9
 */
fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return emptyList()
    }
    val rows = matrix.size
    val columns = matrix[0].size
    val result = ArrayList<Int>()
    // 原始模式 -> 避免重复遍历元素 ->
    // matrix[0][0] ~ matrix[0][n - 1] -> matrix[0][0] ~ matrix[0][n-1]
    // matrix[0][n-1] ~ matrix[m - 1][n - 1] -> matrix[1][n-1] ~ matrix[m-1][n-1]
    // matrix[m-1][n-1] downTo matrix[m-1][0] -> matrix[m-1][n-2] downTo matrix[m-1][0]
    // matrix[m-1][0] downTo matrix[0][0] -> matrix[m-2][0] downTo matrix[1][0]
    var left = 0
    var right = columns - 1
    var top = 0
    var bottom = rows - 1
    while (left <= right && top <= bottom) {
        for (i in left..right) {
            result.add(matrix[top][i])
        }
        for (i in top + 1..bottom) {
            result.add(matrix[i][right])
        }
        if (left < right && top < bottom) {
            for (i in right - 1 downTo left + 1) {
                result.add(matrix[bottom][i])
            }
            for (i in bottom downTo top + 1) {
                result.add(matrix[i][left])
            }
        }
        left++
        right--
        top++
        bottom--
    }
    return result
}