package leetcode.one

/**
 * 39. 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val ans = ArrayList<ArrayList<Int>>()
    val combine = ArrayList<Int>()
    dfs(candidates, target, ans, combine, 0)
    return ans
}

private fun dfs(
    candidates: IntArray,
    target: Int,
    ans: ArrayList<ArrayList<Int>>,
    combine: MutableList<Int>,
    idx: Int
) {
    if (idx == candidates.size) {
        return
    }
    if (target == 0) {
        ans.add(ArrayList(combine))
        return
    }
    // 直接跳过
    dfs(candidates, target, ans, combine, idx + 1)
    // 选择当前数
    if (target - candidates[idx] >= 0) {
        combine.add(candidates[idx])
        dfs(candidates, target - candidates[idx], ans, combine, idx)
        combine.removeAt(combine.size - 1)
    }
}
