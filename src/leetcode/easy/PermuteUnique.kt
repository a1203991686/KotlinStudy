package leetcode.easy

import java.util.*
import kotlin.collections.ArrayList

/**
 * 47. 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 * @author littlecorgi
 * @date 2020/9/18
 */
private lateinit var vis: BooleanArray

fun permuteUnique(nums: IntArray): List<List<Int>> {
    val results = ArrayList<ArrayList<Int>>()
    val combiner = ArrayList<Int>()
    vis = BooleanArray(nums.size) {
        false
    }
    Arrays.sort(nums)
    back(nums, results, combiner, 0)
    return results
}

private fun back(nums: IntArray, results: ArrayList<ArrayList<Int>>, combiner: ArrayList<Int>, idx: Int) {
    if (idx == nums.size) {
        results.add(ArrayList(combiner))
        return
    }

    for (i in nums.indices) {
        if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
            continue
        }
        combiner.add(nums[i])
        vis[i] = true
        back(nums, results, combiner, idx + 1)
        vis[i] = false
        combiner.removeAt(idx)
    }
}