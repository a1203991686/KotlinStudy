package leetcode.difficult

/**
 *
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun firstMissingPositive(nums: IntArray): Int {
    val n = nums.size
    for (i in nums.indices) {
        if (nums[i] <= 0) {
            nums[i] = n + 1
        }
    }
    for (i in 0 until n) {
        val num = Math.abs(nums[i])
        if (num <= n) {
            nums[num - 1] = -Math.abs(nums[num - 1])
        }
    }
    for (i in 0 until n) {
        if (nums[i] > 0) {
            return i + 1
        }
    }
    return n + 1
}