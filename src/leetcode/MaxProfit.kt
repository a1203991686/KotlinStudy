package leetcode

/**
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
fun maxProfit1(prices: IntArray): Int {
    var min = Int.MAX_VALUE
    var max = 0
    for (i in prices) {
        if (i < min) {
            min = i
        } else if (i - min > max) {
            max = i - min
        }
    }
    return max
}

/**
 * 122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
// fun maxProfit2(prices: IntArray): Int {
//     var result = 0
//     var min = Int.MAX_VALUE
//     for (i in prices.indices) {
//         if (i == prices.size - 1) {
//             if (min != Int.MAX_VALUE) {
//                 result += prices[i] - min
//                 continue
//             } else {
//                 continue
//             }
//         }
//         if (prices[i] < min && prices[i] < prices[i + 1]
//         ) {
//             min = prices[i]
//         } else if (min != Int.MAX_VALUE) {
//             if (prices[i] < prices[i + 1]) {
//                 continue
//             } else {
//                 result += prices[i] - min
//                 min = Int.MAX_VALUE
//             }
//         }
//     }
//     return result
// }
fun maxProfit2(prices: IntArray): Int {
    var result = 0
    for (i in 1 until prices.size) {
        if (prices[i] > prices[i - 1]) {
            result += prices[i] - prices[i - 1]
        }
    }
    return result
}

/**
 * 309. 最佳买卖股票时机含冷冻期
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
fun maxProfit5(prices: IntArray): Int {
    if (prices.isEmpty()) {
        return 0
    }
    val n = prices.size
    // f[i][0]: 手上持有股票的最大收益
    // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
    // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
    val f = Array(n) {
        IntArray(3)
    }
    f[0][0] = -prices[0]
    for (i in 1 until n) {
        f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i])
        f[i][1] = f[i - 1][0] + prices[i]
        f[i][2] = Math.max(f[i - 1][1], f[i - 1][2])
    }
    return Math.max(f[n - 1][1], f[n - 1][2])
}
