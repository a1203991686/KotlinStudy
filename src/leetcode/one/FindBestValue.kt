package leetcode.one

import java.util.*

/**
 * 1300. 转变数组后最接近目标值的数组和
 * https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun findBestValue(arr: IntArray, target: Int): Int {
    if (arr.isEmpty()) {
        return 0
    }
    Arrays.sort(arr)
    var sum = 0
    for (i in arr.indices) {
        val x = (target - sum) / (arr.size - i)
        if (x < arr[i]) {
            val t = ((target - sum)).toDouble() / (arr.size - i)
            return if (t - x > 0.5) {
                x + 1
            } else {
                x
            }
        }
        sum += arr[i]
    }
    return arr[arr.size - 1]
}
