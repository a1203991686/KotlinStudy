package leetcode.tencent.sort_search

/**
 * 数组中的第K个最大元素
 * https://leetcode-cn.com/leetbook/read/tencent/x5txi7/
 * @author littlecorgi
 * @date 2020/10/6
 */
fun findKthLargest(nums: IntArray, k: Int): Int {
    val n = nums.size
    val target = n - k
    return qSort(0, n - 1, nums, target)
}

private fun qSort(left: Int, right: Int, nums: IntArray, target: Int): Int {
    // println("$left $right")
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
        val t = nums[leftTemp]
        nums[leftTemp] = nums[rightTemp]
        nums[rightTemp] = t
    }
    val t = nums[left]
    nums[left] = nums[rightTemp]
    nums[rightTemp] = t
    // for (i in nums) {
    //     print("$i ")
    // }
    // println()
    return when {
        target < leftTemp -> {
            qSort(left, leftTemp - 1, nums, target)
        }
        target > leftTemp -> {
            qSort(rightTemp + 1, right, nums, target)
        }
        else -> {
            nums[target]
        }
    }
}
