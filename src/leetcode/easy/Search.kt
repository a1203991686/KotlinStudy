package leetcode.easy

/**
 * 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun search(nums: IntArray, target: Int): Int {
    val n = nums.size
    if (n == 0) {
        return -1
    }
    if (n == 1) {
        return if (nums[0] == target) 0 else -1
    }
    var l = 0
    var r = n - 1
    while (l <= r) {
        val mid = (l + r) / 2
        if (nums[mid] == target) {
            return mid
        }
        if (nums[0] <= nums[mid]) {
            if (nums[0] <= target && target < nums[mid]) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        } else {
            if (nums[mid] < target && target <= nums[n - 1]) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
    }
    return -1
}
