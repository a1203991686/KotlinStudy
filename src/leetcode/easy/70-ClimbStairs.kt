package leetcode.easy

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun climbStairs(n: Int): Int {
    if (n == 0) {
        return 0
    }
    if (n == 1) {
        return 1
    }
    if (n == 2) {
        return 2
    }
    val dps = IntArray(n + 1)
    dps[0] = 0
    dps[1] = 1
    dps[2] = 2
    for (i in 3..n) {
        dps[i] = dps[i - 1] + dps[i - 2]
    }
    println(dps.toList())
    return dps[n]
}
