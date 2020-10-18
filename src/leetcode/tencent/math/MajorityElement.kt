package leetcode.tencent.math

/**
 * 多数元素
 * https://leetcode-cn.com/leetbook/read/tencent/x5yxxs/
 * @author littlecorgi
 * @date 2020/10/18
 */
fun majorityElement(nums: IntArray): Int {
    val map = HashMap<Int, Int>()
    val n = nums.size / 2
    for (i in nums) {
        if (map.containsKey(i)) {
            map[i] = map[i]!!.plus(1)
        } else {
            map[i] = 1
        }
        if (map[i]!! > n) {
            return i
        }
    }
    return -1
}
