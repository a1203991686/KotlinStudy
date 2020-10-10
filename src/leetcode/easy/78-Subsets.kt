package leetcode.easy

import java.util.*
import kotlin.collections.ArrayList

/**
 * 78. 子集
 * https://leetcode-cn.com/problems/subsets/
 * @author littlecorgi
 * @date 2020/9/20
 */
fun subsets(nums: IntArray): List<List<Int>> {
    Arrays.sort(nums)
    val result = ArrayList<ArrayList<Int>>()
    val combiner = ArrayList<Int>()
    val vis = BooleanArray(nums.size) {
        false
    }
    back(nums, result, combiner, 0, vis)
    return result
}

private fun back(
    nums: IntArray,
    result: ArrayList<ArrayList<Int>>,
    combiner: ArrayList<Int>,
    idx: Int,
    vis: BooleanArray
) {
    if (idx > nums.size) {
        return
    }
    if (!result.contains(combiner)) {
        result.add(ArrayList(combiner))
    }

    for (i in idx until nums.size) {
        if (!vis[i]) {
            combiner.add(nums[i])
            vis[i] = true
            back(nums, result, combiner, i + 1, vis)
            vis[i] = false
            combiner.removeAt(combiner.lastIndex)
        }
    }
}