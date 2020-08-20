package leetcode.easy

/**
 * 529. 扫雷游戏
 * https://leetcode-cn.com/problems/minesweeper/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
private val dirX = intArrayOf(0, 1, 0, -1, 1, 1, -1, -1)
private val dirY = intArrayOf(1, 0, -1, 0, 1, -1, 1, -1)

fun updateBoard(board: Array<CharArray>, click: IntArray): Array<CharArray> {
    val x = click[0]
    val y = click[1]
    if (board[x][y] == 'M') {
        board[x][y] = 'X'
    } else {
        dfs(board, x, y)
    }
    return board
}

private fun dfs(board: Array<CharArray>, x: Int, y: Int) {
    var cnt = 0
    for (i in 0..7) {
        val tx = x + dirX[i]
        val ty = y + dirY[i]
        if (tx < 0 || tx >= board.size || ty < 0 || ty >= board[0].size) {
            continue
        }
        if (board[tx][ty] == 'M') {
            ++cnt
        }
    }
    if (cnt > 0) {
        // 规则3
        board[x][y] = cnt + '0'
    } else {
        // 规则2
        board[x][y] = 'B'
        for (i in 0..7) {
            val tx = x + dirX[i]
            val ty = y + dirY[i]
            if (tx < 0 || tx >= board.size || ty < 0 || ty >= board[0].size || board[tx][ty] != 'E') {
                continue
            }
            dfs(board, tx, ty)
        }
    }
}

private operator fun Int.plus(c: Char): Char {
    val a = '0'.toInt()
    return (this + a).toChar()
}
