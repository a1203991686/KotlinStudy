package leetcode.difficult

/**
 * 546. 移除盒子
 * https://leetcode-cn.com/problems/remove-boxes/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun removeBoxes(boxes: IntArray): Int {
    val dp = Array(100) {
        Array(100) {
            IntArray(100)
        }
    }
    return calculatePoints(boxes, dp, 0, boxes.size - 1, 0)
}

fun calculatePoints(boxes: IntArray, dp: Array<Array<IntArray>>, l: Int, r: Int, k: Int): Int {
    if (l > r) return 0
    if (dp[l][r][k] != 0) return dp[l][r][k]
    var tempR = r
    var tempK = k
    while (tempR > l && boxes[tempR] == boxes[tempR - 1]) {
        tempR--
        tempK++
    }
    dp[l][tempR][tempK] = calculatePoints(boxes, dp, l, tempR - 1, 0) + (tempK + 1) * (tempK + 1)
    for (i in l until tempR) {
        if (boxes[i] == boxes[tempR]) {
            dp[l][tempR][tempK] = Math.max(
                dp[l][tempR][tempK],
                calculatePoints(
                    boxes,
                    dp,
                    l,
                    i,
                    tempK + 1
                ) + calculatePoints(
                    boxes,
                    dp,
                    i + 1,
                    tempR - 1,
                    0
                )
            )
        }
    }
    return dp[l][tempR][tempK]
}