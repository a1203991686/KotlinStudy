package leetcode.easy

import java.util.*

/**
 * 16. 最接近的三数之和
 * https://leetcode-cn.com/problems/3sum-closest/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun threeSumClosest(nums: IntArray, target: Int): Int {
    Arrays.sort(nums)
    var result = Int.MAX_VALUE
    //枚举a
    for (i in nums.indices) {
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }
        var j = i + 1
        var k = nums.size - 1
        while (j < k) {
            val tempSum = nums[i] + nums[j] + nums[k]
            if (tempSum == target) {
                return target
            }
            if (Math.abs(tempSum - target) < Math.abs(result.toLong() - target)) {
                result = tempSum
            }
            if (tempSum > target) {
                var k0 = k - 1
                while (j < k0 && nums[k0] == nums[k]) {
                    k0--
                }
                k--
            } else if (tempSum < target) {
                var j0 = j + 1
                while (j0 < k && nums[j0] == nums[j]) {
                    j0++
                }
                j++
            }
        }
    }
    return result
}