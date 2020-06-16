package leetcode.one

/**
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun rob(nums: IntArray): Int {
    val dp = IntArray(nums.size)
    for (i in nums.indices) {
        when (i) {
            0 -> dp[i] = nums[i]
            1 -> dp[i] = Math.max(nums[0], nums[1])
            in 2 until nums.size -> dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1])
            else -> throw Exception("指针小于0，循环出现错误")
        }
    }
    return if (nums.isNotEmpty()) {
        dp[nums.size - 1]
    } else {
        0
    }
}


fun main() {
    val nums = intArrayOf()
    println(rob(nums))
}
