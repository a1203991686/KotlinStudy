package leetcode.tencent.math

/**
 * 只出现一次的数字
 * https://leetcode-cn.com/leetbook/read/tencent/x51e9r/
 * @author littlecorgi
 * @date 2020/10/18
 */
fun singleNumber(nums: IntArray): Int {
    var result = nums[0]
    for (i in 1 until nums.size) {
        result = result.xor(nums[i])
    }
    return result
}
