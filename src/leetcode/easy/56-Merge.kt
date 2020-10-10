package leetcode.easy

import java.util.*

/**
 * 56. 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun merge(intervals: Array<IntArray>): Array<IntArray> {
    val res: MutableList<IntArray> = ArrayList()
    if (intervals.isEmpty()) return res.toTypedArray()
    // 对起点终点进行排序
    Arrays.sort(
        intervals
    ) { a: IntArray, b: IntArray -> a[0] - b[0] }
    var i = 0
    while (i < intervals.size) {
        val left = intervals[i][0]
        var right = intervals[i][1]
        // 如果有重叠，循环判断哪个起点满足条件
        while (i < intervals.size - 1 && intervals[i + 1][0] <= right) {
            i++
            right = Math.max(right, intervals[i][1])
        }
        // 将现在的区间放进res里面
        res.add(intArrayOf(left, right))
        // 接着判断下一个区间
        i++
    }
    return res.toTypedArray()
}
