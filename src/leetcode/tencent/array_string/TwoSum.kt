package leetcode.tencent.array_string

/**
 * 两数之和
 * https://leetcode-cn.com/leetbook/read/tencent/xxqfy5/
 * @author littlecorgi
 * @date 2020/10/6
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    val hashMap = HashMap<Int, Int>()
    for (i in nums.indices) {
        if (hashMap.containsKey(target - nums[i])) {
            return intArrayOf(i, hashMap[target - nums[i]]!!)
        }
        hashMap[nums[i]] = i
    }
    return intArrayOf()
}