package leetcode.tencent.array_string.review

/**
 * 盛最多水的容器
 * https://leetcode-cn.com/leetbook/read/tencent/xxcmit/
 * @author littlecorgi
 * @date 2020/10/8
 */
fun maxArea(height: IntArray): Int {
    var l = 0
    var r = height.size - 1
    var result = 0
    while (l < r) {
        val min = if (height[l] < height[r]) height[l] else height[r]
        val s = min * (r - l)
        // println("s=$s, l=$l, r=$r")
        if (s > result) {
            result = s
        } else {
            if (height[l] < height[r]) {
                l++
            } else {
                r--
            }
        }
    }
    return result
}
