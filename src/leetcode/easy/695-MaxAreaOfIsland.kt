package leetcode.easy

import java.util.*

/**
 * 695. 岛屿的最大面积
 * https://leetcode-cn.com/problems/max-area-of-island/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    var result = 0
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == 0) {
                continue
            } else {
                val tempResult = dfs(grid, i, j)
                result = Math.max(result, tempResult)
            }
        }
    }
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            print("${grid[i][j]} ")
        }
        println()
    }
    return result
}

fun dfs(grid: Array<IntArray>, i: Int, j: Int): Int {
    val stack = Stack<Pair<Int, Int>>()
    var result = 0
    stack.add(Pair(i, j))
    while (stack.isNotEmpty()) {
        val (x, y) = stack.pop()
        println("$x $y ${grid[x][y]}")
        if (grid[x][y] == 1) {
            result++
            if (y + 1 < grid[0].size && grid[x][y + 1] != 0) {
                stack.add(Pair(x, y + 1))
            }
            if (x + 1 < grid.size && grid[x + 1][y] != 0) {
                stack.add(Pair(x + 1, y))
            }
            if (y - 1 >= 0 && grid[x][y - 1] != 0) {
                stack.add(Pair(x, y - 1))
            }
            if (x - 1 >= 0 && grid[x - 1][y] != 0) {
                stack.add(Pair(x - 1, y))
            }
            grid[x][y] = 0
        } else {
            continue
        }
    }
    println(result)
    println()
    return result
}