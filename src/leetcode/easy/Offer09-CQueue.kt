package leetcode.easy

import java.util.*

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
class `Offer09-CQueue`() {
    private val inStack = Stack<Int>()
    private val outStack = Stack<Int>()

    fun appendTail(value: Int) {
        inStack.push(value)
    }

    fun deleteHead(): Int {
        if (inStack.isEmpty()) {
            return -1
        }
        while (inStack.isNotEmpty()) {
            outStack.push(inStack.pop())
        }
        val result = outStack.pop()
        while (outStack.isNotEmpty()) {
            inStack.push(outStack.pop())
        }
        return result
    }
}