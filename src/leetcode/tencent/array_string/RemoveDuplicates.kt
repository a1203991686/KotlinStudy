package leetcode.tencent.array_string

/**
 * 删除排序数组中的重复项
 * https://leetcode-cn.com/leetbook/read/tencent/xxynuj/
 * @author littlecorgi
 * @date 2020/10/7
 */
fun removeDuplicates(nums: IntArray): Int {
    if (nums.size == 1) {
        return 1
    }
    var num = 0
    for (i in nums.indices) {
        if (i != nums.size - 1 && nums[i] != nums[i + 1]) {
            val temp = nums[i]
            nums[i] = nums[num]
            nums[num] = temp
            num++
        }
        // 最后一个元素，并且和num处的元素不同
        if (i == nums.size - 1 && num != 0 && nums[i] != nums[num - 1]) {
            val temp = nums[i]
            nums[i] = nums[num]
            nums[num] = temp
            num++
        }
    }
    // 解决 [1，1] 的情况
    if (num == 0 && nums.isNotEmpty()) {
        num++
    }
    return num
}