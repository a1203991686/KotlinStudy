package leetcode.tencent.array_string

import java.util.*
import kotlin.collections.ArrayList

/**
 * 三数之和
 * https://leetcode-cn.com/leetbook/read/tencent/xxst6e/
 * @author littlecorgi
 * @date 2020/10/7
 */
fun threeSum(nums: IntArray): List<List<Int>> {
    val result = ArrayList<ArrayList<Int>>()
    val n = nums.size
    if (n < 3) {
        return result
    }
    Arrays.sort(nums)
    for (i in 0 .. n - 3) {
        // 当当前3个的值大于0，后面的就没必要继续遍历了，因为后面的元素比当前元素更大。
        if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
            break
        }
        val temp = nums[i]
        // 双指针，变为两数之和问题
        var l = i + 1
        var r = n - 1
        while (l < r) {
            val sumTemp = temp + nums[l] + nums[r]
            when {
                sumTemp > 0 -> r--
                sumTemp < 0 -> l++
                sumTemp == 0 -> {
                    // 去重
                    val combiner = arrayListOf(temp, nums[l], nums[r])
                    if (!result.contains(combiner)) {
                        result.add(combiner)
                    }
                    // 更新索引
                    r--
                    l++
                }
            }
        }
    }
    return result
}
