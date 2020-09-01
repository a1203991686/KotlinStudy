package leetcode.difficult

/**
 * 486. 预测赢家
 * https://leetcode-cn.com/problems/predict-the-winner/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun PredictTheWinner(nums: IntArray): Boolean {
    return total(nums, 0, nums.size - 1, 1) >= 0
}

private fun total(nums: IntArray, start: Int, end: Int, turn: Int): Int {
    if (start == end) {
        return nums[start] * turn
    }
    val scoreStart = nums[start] * turn + total(nums, start + 1, end, -turn)
    val scoreEnd = nums[end] * turn + total(nums, start, end - 1, -turn)
    return Math.max(scoreStart * turn, scoreEnd * turn) * turn
}