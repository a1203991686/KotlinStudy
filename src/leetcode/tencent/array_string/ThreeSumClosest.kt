package leetcode.tencent.array_string

import java.util.*

/**
 * 最接近的三数之和
 * https://leetcode-cn.com/leetbook/read/tencent/xx4l3g/
 * @author littlecorgi
 * @date 2020/10/7
 */
fun threeSumClosest(nums: IntArray, target: Int): Int {
    val n = nums.size
    if (n < 3) {
        return 0
    }
    var result = nums[0] + nums[1] + nums[2]
    Arrays.sort(nums)
    for (i in 0..n - 3) {
        val temp = nums[i]
        // 双指针，变为两数之和问题
        var l = i + 1
        var r = n - 1
        while (l < r) {
            val sumTemp = temp + nums[l] + nums[r]
            // println("$temp ${nums[l]} ${nums[r]}")
            if (Math.abs(sumTemp - target) < Math.abs(result - target)) {
                // println("update: $sumTemp")
                result = sumTemp
            }
            if (sumTemp > target) {
                var r0 = r
                while (l < r0 && nums[r0] == nums[r]) {
                    r0--
                }
                r = r0
            } else {
                var l0 = l
                while (l0 < r && nums[l0] == nums[l]) {
                    l0++
                }
                l = l0
            }
        }
    }
    return result
}
