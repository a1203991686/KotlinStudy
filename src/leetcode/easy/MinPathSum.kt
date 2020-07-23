package leetcode.easy

/**
 * 64. 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun minPathSum(grid: Array<IntArray>): Int {
    val lengthX = grid[0].size
    val lengthY = grid.size
    val result = Array(lengthY) {
        IntArray(lengthX) {
            0
        }
    }
    result[0][0] = grid[0][0]
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (i == 0 && j == 0) {
                continue
            }
            if (i == 0) {
                result[0][j] += result[0][j - 1] + grid[0][j]
                continue
            }
            if (j == 0) {
                result[i][0] += result[i - 1][0] + grid[i][0]
                continue
            }
            result[i][j] = Math.min(result[i - 1][j], result[i][j - 1]) + grid[i][j]
        }
    }
    return result[lengthY - 1][lengthX - 1]
}
