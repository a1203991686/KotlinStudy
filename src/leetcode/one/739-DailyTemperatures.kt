package leetcode.one

import java.util.*

/**
 * 739. 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun dailyTemperatures(T: IntArray): IntArray {
    val temperatureStack = Stack<Int>()
    val ans = IntArray(T.size)
    for (i in T.indices) {
        val temperature = T[i]
        while (temperatureStack.isNotEmpty() && temperature > T[temperatureStack.peek()]) {
            val preIndex = temperatureStack.pop()
            ans[preIndex] = i - preIndex
        }
        temperatureStack.push(i)
    }
    return ans
}