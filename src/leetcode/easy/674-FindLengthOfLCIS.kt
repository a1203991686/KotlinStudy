package leetcode.easy

/**
 * 674. 最长连续递增序列
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun findLengthOfLCIS(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }
    if (nums.size == 1) {
        return 1
    }
    var result = 0
    var temp = 0
    for (i in nums.indices) {
        if (i == nums.size - 1) {
            if (nums[i - 1] <= nums[i]) {
                temp++
            }
            result = Math.max(result, temp)
            break
        }
        if (nums[i] < nums[i + 1]) {
            temp++
        } else {
            temp++
            result = Math.max(result, temp)
            temp = 0
        }
    }
    return result
}