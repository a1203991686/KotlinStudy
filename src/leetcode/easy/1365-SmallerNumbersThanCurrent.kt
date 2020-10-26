package leetcode.easy

/**
 * 1365. 有多少小于当前数字的数字 !!!没写完，懒得写了
 * https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * @author littlecorgi
 * @date 2020/10/26
 */
fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
    val n = nums.size
    qSort(0, n - 1, nums)
    for (i in nums) {
        print("$i ")
    }
    val ret = IntArray(n)
    var prev = -1
    for (i in 0 until n) {
        // if (prev == -1 || nums[i][0])
    }
    return intArrayOf()
}

private fun qSort(left: Int, right: Int, nums: IntArray) {
    if (left >= right) {
        return
    }
    var l = left + 1
    var r = right
    val temp = nums[left]
    while (l < r) {
        while (l < r && nums[r] > temp) {
            r--
        }
        while (l < r && nums[l] < temp) {
            l++
        }
        if (l < r) {
            val t = nums[l]
            nums[l] = nums[r]
            nums[r] = t
        }
    }
    if (l == r) {
        val t = nums[l]
        nums[l] = nums[left]
        nums[left] = t
    }
    qSort(left, l - 1, nums)
    qSort(l + 1, right, nums)
}