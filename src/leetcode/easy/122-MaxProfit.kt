package leetcode.easy

/**
 * 122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @author littlecorgi
 * @date 2020/11/8
 */
fun maxProfit(prices: IntArray) = run {
    var ans = 0
    for (i in 1 until prices.size) {
        ans += Math.max(0, prices[i] - prices[i - 1])
    }
    ans
}
