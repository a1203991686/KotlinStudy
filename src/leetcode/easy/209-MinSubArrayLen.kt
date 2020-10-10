package leetcode.easy

/**
 * 209. 长度最小的子数组
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun minSubArrayLen(s: Int, nums: IntArray): Int {
    if (s <= 0 || nums.isEmpty()) {
        return 0
    }

    var ans = Int.MAX_VALUE
    var start = 0
    var end = 0
    var sum = 0
    while (end < nums.size) {
        sum += nums[end]
        while (sum >= s) {
            ans = Math.min(ans, end - start + 1)
            sum -= nums[start]
            start++
        }
        end++
    }
    return if (ans == Int.MAX_VALUE) 0 else ans
}