package leetcode.tencent.array_string.review

/**
 * 除自身以外数组的乘积
 * https://leetcode-cn.com/leetbook/read/tencent/xxfcwh/
 * @author littlecorgi
 * @date 2020/10/9
 */
fun productExceptSelf(nums: IntArray): IntArray {
    if (nums.isEmpty()) {
        return intArrayOf()
    }
    val n = nums.size
    val result = IntArray(nums.size)
    result[0] = 1
    result[n - 1] = 1
    for (i in nums.indices) {
        if (i != 0) {
            result[i] = result[i - 1] * nums[i - 1]
        }
    }
    var R = 1
    for (i in n - 1 downTo 0) {
        result[i] *= R
        R *= nums[i]
    }
    return result
}
