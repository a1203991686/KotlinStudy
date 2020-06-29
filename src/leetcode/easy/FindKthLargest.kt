package leetcode.easy

/**
 * 215. 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun findKthLargest(nums: IntArray, k: Int): Int {
    return qSort(nums, 0, nums.size - 1, nums.size - k)
}

fun qSort(nums: IntArray, left: Int, right: Int, target: Int): Int {
    if (nums.isEmpty() || left > right) {
        return -1
    }
    val temp = nums[left]
    var i = left
    var j = right
    while (i != j) {
        while (nums[j] >= temp && i < j) {
            j--
        }
        while (nums[i] <= temp && i < j) {
            i++
        }
        if (i < j) {
            val t = nums[i]
            nums[i] = nums[j]
            nums[j] = t
        }
    }
    nums[left] = nums[i]
    nums[i] = temp
    if (i == target) {
        return temp
    } else {
        return if (i < target) qSort(
            nums,
            i + 1,
            right,
            target
        ) else qSort(nums, left, i - 1, target)
    }
}
