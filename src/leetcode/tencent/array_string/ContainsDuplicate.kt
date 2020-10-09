package leetcode.tencent.array_string

/**
 * 存在重复元素
 * https://leetcode-cn.com/leetbook/read/tencent/x5h4n3/
 * @author littlecorgi
 * @date 2020/10/9
 */
fun containsDuplicate(nums: IntArray): Boolean {
    val n = nums.size
    qSort(nums, 0, n - 1)
    for (i in 0 until n - 1) {
        if (nums[i] == nums[i + 1]) {
            return true
        }
    }
    return false
}

private fun qSort(nums: IntArray, left: Int, right: Int) {
    if (left >= right) {
        return
    }
    val temp = nums[left]
    var leftTemp = left
    var rightTemp = right
    while (leftTemp < rightTemp) {
        while (nums[rightTemp] >= temp && leftTemp < rightTemp) {
            rightTemp--
        }
        while (nums[leftTemp] <= temp && leftTemp < rightTemp) {
            leftTemp++
        }
        swap(nums, leftTemp, rightTemp)
    }
    if (nums[leftTemp] != nums[left]) {
        swap(nums, leftTemp, left)
    }
    qSort(nums, left, leftTemp - 1)
    qSort(nums, rightTemp + 1, right)
}

private fun swap(nums: IntArray, i: Int, j: Int) {
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}
