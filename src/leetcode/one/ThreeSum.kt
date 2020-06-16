package leetcode.one

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun threeSum(nums: IntArray): List<List<Int>> {
    val result = ArrayList<ArrayList<Int>>()
    nums.sort()
    println(nums.toList())
    for (i in nums.indices) {
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }
        if (nums[i] <= 0) {
            var left = i + 1
            var right = nums.size - 1
            val target = 0 - nums[i]
            while (left < right) {
                val temp = ArrayList<Int>()
                when {
                    nums[left] + nums[right] == target -> {
                        temp.add(0 - target)
                        temp.add(nums[left])
                        temp.add(nums[right])
                        left++
                        right--
                        result.add(temp)
                    }
                    nums[left] + nums[right] < target -> {
                        left++
                    }
                    nums[left] + nums[right] > target -> {
                        right--
                    }
                }
                if (left - 1 >= 0 && nums[left] == nums[left - 1]) {
                    left++
                }
                if (right + 1 < nums.size
                    && nums[right] ==
                    nums[right + 1]
                ) {
                    right--
                }
            }
        }
    }
    return result
}