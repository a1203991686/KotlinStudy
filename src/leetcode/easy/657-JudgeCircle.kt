package leetcode.easy

/**
 * 657. 机器人能否返回原点
 * https://leetcode-cn.com/problems/robot-return-to-origin/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun judgeCircle(moves: String): Boolean {
    var x = 0
    var y = 0
    val length = moves.length
    for (i in 0 until length) {
        val move = moves[i]
        when (move) {
            'U' -> y--
            'D' -> y++
            'L' -> x--
            'R' -> x++
        }
    }
    return x == 0 && y == 0
}