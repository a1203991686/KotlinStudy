package leetcode.tencent.array_string.review

/**
 * 合并两个有序数组
 * https://leetcode-cn.com/leetbook/read/tencent/x5mohi/
 * @author littlecorgi
 * @date 2020/10/9
 */
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    val nums1Copy = IntArray(m)
    System.arraycopy(nums1, 0, nums1Copy, 0, m)
    var index1 = 0
    var index2 = 0
    var p = 0
    while (index1 < m && index2 < n) {
        nums1[p++] = if (nums1Copy[index1] < nums2[index2]) nums1Copy[index1++] else nums2[index2++]
    }

    if (index1 < m) {
        System.arraycopy(nums1Copy, index1, nums1, index1 + index2, m + n - index1 - index2)
    }
    if (index2 < n) {
        System.arraycopy(nums2, index2, nums1, index1 + index2, m + n - index1 - index2)
    }
}