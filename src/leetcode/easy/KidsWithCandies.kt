package leetcode.easy

/**
 * 1431. 拥有最多糖果的孩子
 * https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */

fun kidsWithCandies(candies: IntArray, extraCandies: Int): BooleanArray {
    val results = BooleanArray(candies.size) {
        false
    }

    var max = 0
    for (i in candies.indices) {
        if (candies[i] > max) {
            max = candies[i]
        }
    }

    for (i in candies.indices) {
        if (max - candies[i] <= extraCandies) {
            results[i] = true
        }
    }
    return results
}