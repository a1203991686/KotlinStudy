package leetcode.easy

/**
 * 518. 零钱兑换 II
 * https://leetcode-cn.com/problems/coin-change-2/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun change(amount: Int, coins: IntArray): Int {
    val dp = IntArray(amount + 1) {
        0
    }
    dp[0] = 1
    for (i in coins.indices) {
        for (j in coins[i]..amount) {
            dp[j] = dp[j - coins[i]] + dp[j]
        }
    }
    return dp[amount]
}