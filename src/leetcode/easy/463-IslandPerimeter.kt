package leetcode.easy

/**
 * 463. 岛屿的周长
 * https://leetcode-cn.com/problems/island-perimeter/
 * @author littlecorgi
 * @date 2020/10/30
 */
private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(1, 0, -1, 0)
fun islandPerimeter(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    var ans = 0
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (grid[i][j] == 1) {
                var cnt = 0
                for (k in 0 until 4) {
                    val tx = i + dx[k]
                    val ty = j + dy[k]
                    if (tx < 0 || tx >= m || ty < 0 || ty >= n || grid[tx][ty] == 0) {
                        cnt++
                    }
                }
                ans += cnt
            }
        }
    }
    return ans
}
