package leetcode.easy

/**
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * @author littlecorgi
 * @date 2020/10/3
 */
/*fun twoSum(nums: IntArray, target: Int): IntArray {
    val tempNums = nums
    var left = 0
    var right = tempNums.size - 1
    while (left <= right) {
        val temp = tempNums[left] + tempNums[right]
        if (temp > target) {
            right--
        } else if (temp < target) {
            left++
        } else {
            break
        }
    }
    return intArrayOf(nums.indexOf(tempNums[left]), nums.indexOf(tempNums[right]))
}*/

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
