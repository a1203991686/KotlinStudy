package leetcode.easy

import leetcode.ListNode

/**
 * 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @author littlecorgi
 * @date 2020/10/4
 */
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var result = ListNode(0)
    var l1Index = l1
    var l2Index = l2
    var flag = false
    var a = true
    var pre = result
    while (l1Index != null || l2Index != null) {
        val temp = if (flag) ListNode(1) else ListNode(0)
        if (l1Index != null) {
            temp.`val` += l1Index.`val`
            l1Index = l1Index.next
        }
        if (l2Index != null) {
            temp.`val` += l2Index.`val`
            l2Index = l2Index.next
        }
        if (temp.`val` >= 10) {
            temp.`val` -= 10
            flag = true
        } else {
            flag = false
        }
        if (a) {
            // 如果是第一次
            result = temp
            pre = result
            a = false
        } else {
            pre.next = temp
            pre = temp
        }
    }
    if (flag) {
        val temp = ListNode(1)
        pre.next = temp
    }
    return result
}