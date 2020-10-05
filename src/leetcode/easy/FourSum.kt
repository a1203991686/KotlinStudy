package leetcode.easy

import java.util.*
import kotlin.collections.ArrayList

/**
 * 18. 四数之和
 * https://leetcode-cn.com/problems/4sum/
 * @author littlecorgi
 * @date 2020/10/5
 */
// 双指针
fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    val result = ArrayList<ArrayList<Int>>()
    if (nums.isEmpty()) {
        return result
    }
    Arrays.sort(nums)
    val n = nums.size
    for (i in 0 until n - 3) {
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }
        if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
            break
        }
        if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
            continue
        }
        for (j in i + 1 until n - 2) {
            if (j > i + 1 && nums[j] == nums[j - 1]) {
                continue
            }
            if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                break
            }
            if (nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) {
                continue
            }
            var left = j + 1
            var right = n - 1
            while (left < right) {
                val sum = nums[i] + nums[j] + nums[left] + nums[right]
                when {
                    sum == target -> {
                        result.add(arrayListOf(nums[i], nums[j], nums[left], nums[right]))
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++
                        }
                        left++
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--
                        }
                        right--
                    }
                    sum < target -> {
                        left++
                    }
                    else -> {
                        right--
                    }
                }
            }
        }
    }
    return result
}

// 全排列
// fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
//     val result = ArrayList<ArrayList<Int>>()
//     val combiner = ArrayList<Int>()
//     Arrays.sort(nums)
//     back(result, combiner, nums, target, 0)
//     return result
// }
//
// private fun back(result: ArrayList<ArrayList<Int>>, combiner: ArrayList<Int>, nums: IntArray, target: Int, idx: Int) {
//     if (combiner.size == 4 && target == 0) {
//         if (!result.contains(combiner)) {
//             result.add(ArrayList(combiner))
//         }
//         return
//     }
//     if (combiner.size > 4) {
//         return
//     }
//
//     for (i in idx until nums.size) {
//         combiner.add(nums[i])
//         back(result, combiner, nums, target - nums[i], i + 1)
//         combiner.removeAt(combiner.lastIndex)
//     }
// }
