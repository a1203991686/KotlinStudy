package leetcode.easy

import java.util.*

/**
 * 42. 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun trap(height: IntArray): Int {
    var ans = 0
    var current = 0
    val st = Stack<Int>()
    while (current < height.size) {
        while (st.isNotEmpty() && height[current] > height[st.peek()]) {
            val top = st.pop()
            if (st.empty()) {
                break
            }
            val distance = current - st.peek() - 1
            val boundedHeight = Math.min(height[current], height[st.peek()]) - height[top]
            ans += distance * boundedHeight
        }
        st.push(current++)
    }
    return ans
}