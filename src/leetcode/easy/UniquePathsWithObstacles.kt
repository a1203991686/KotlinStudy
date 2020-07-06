package leetcode.easy

/**
 *
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    if (obstacleGrid[0][0] == 1) {
        return 0
    }
    val m = obstacleGrid.size
    val n = obstacleGrid[0].size
    val dps = Array<IntArray>(m) {
        IntArray(n) {
            0
        }
    }
    dps[0][0] = 1
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (obstacleGrid[i][j] == 0) {
                // 此处没有障碍物
                // 如果他的上面没有障碍物，就证明可以从上面走下来
                if (i - 1 >= 0 && obstacleGrid[i - 1][j] == 0) {
                    dps[i][j] += dps[i - 1][j]
                }
                // 如果他的左边没有障碍物，就证明可以从左边走过来
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    dps[i][j] += dps[i][j - 1]
                }
            } else {
                // 此处存在障碍物
                continue
            }
        }
    }
    return dps[m - 1][n - 1]
}
