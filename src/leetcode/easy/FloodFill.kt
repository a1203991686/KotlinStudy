package leetcode.easy

import java.util.*

/**
 * 733. 图像渲染
 * https://leetcode-cn.com/problems/flood-fill/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
private val dx = intArrayOf(1, 0, 0, -1)
private val dy = intArrayOf(0, 1, -1, 0)

fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
    val currColor = image[sr][sc]
    if (currColor == newColor) {
        return image
    }
    val n = image.size
    val m = image[0].size
    val queue = LinkedList<IntArray>()
    queue.offer(intArrayOf(sr, sc))
    image[sr][sc] = newColor
    while (!queue.isEmpty()) {
        val cell = queue.poll()
        val (x, y) = cell
        for (i in 0 until 4) {
            val mx = x + dx[i]
            val my = y + dy[i]
            if (mx in 0 until n && my in 0 until m && image[mx][my] == currColor) {
                queue.offer(intArrayOf(mx, my))
                image[mx][my] = newColor
            }
        }
    }
    return image
}