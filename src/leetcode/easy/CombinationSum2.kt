package leetcode.easy

import kotlin.collections.ArrayList

/**
 * 40. 组合总和 II
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    val result = ArrayList<ArrayList<Int>>()
    val combine = ArrayList<Int>()
    back(result, combine, candidates, target, 0)
    return result
}

private fun back(
    result: ArrayList<ArrayList<Int>>,
    combine: MutableList<Int>,
    candidates: IntArray,
    target: Int,
    idx: Int
) {
    if (idx - 1 == candidates.size) {
        return
    }

    if (target == 0) {
        val temp = ArrayList(combine)
        temp.sort()
        if (!result.contains(temp)) {
            result.add(temp)
        }
    } else {
        for (i in idx until candidates.size) {
            if (target -
                candidates[i] >= 0
            ) {
                combine.add(candidates[i])
                back(result, combine, candidates, target - candidates[i], i + 1)
                combine.removeAt(combine.size - 1)
            }
        }
    }
}