package leetcode.easy

import java.util.*

/**
 * 130. 被围绕的区域
 * https://leetcode-cn.com/problems/surrounded-regions/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)
fun solve(board: Array<CharArray>) {
    if (board.isEmpty()) {
        return
    }
    val n = board.size
    val m = board[0].size
    val queue = LinkedList<IntArray>()
    for (i in 0 until n) {
        if (board[i][0] == 'O') {
            queue.offer(intArrayOf(i, 0))
        }
        if (board[i][m - 1] == 'O') {
            queue.offer(intArrayOf(i, m - 1))
        }
    }
    for (i in 1 until m - 1) {
        if (board[0][i] == 'O') {
            queue.offer(intArrayOf(0, i))
        }
        if (board[n - 1][i] == 'O') {
            queue.offer(intArrayOf(n - 1, i))
        }
    }
    while (queue.isNotEmpty()) {
        val cell = queue.poll()
        val x = cell[0]
        val y = cell[1]
        board[x][y] = 'A'
        for (i in 0..3) {
            val mx = x + dx[i]
            val my = y + dy[i]
            if (mx < 0 || my < 0 || mx >= n || my >= m || board[mx][my] != 'O') {
                continue
            }
            queue.offer(intArrayOf(mx, my))
        }
    }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (board[i][j] == 'A') {
                board[i][j] = 'O'
            } else if (board[i][j] == 'O') {
                board[i][j] = 'X'
            }
        }
    }
}
