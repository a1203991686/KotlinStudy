package leetcode.easy

import leetcode.ListNode

/**
 * 234. 回文链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * @author littlecorgi
 * @date 2020/10/23
 */
fun isPalindrome(head: ListNode?): Boolean {
    if (head == null) {
        return true
    }

    // 找到前半部分链表的尾节点并反转后半部分链表
    val firstHalfEnd = endOfFirstHalf(head)
    val secondHalfStart = reverseList(firstHalfEnd?.next)

    // 判断是否回文
    var p1 = head
    var p2 = secondHalfStart
    var result = true
    while (result && p2 != null) {
        if (p1?.`val` != p2.`val`) {
            result = false
        }
        p1 = p1?.next
        p2 = p2.next
    }

    // 还原链表并返回结果
    firstHalfEnd?.next = reverseList(secondHalfStart)
    return result
}

private fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var curr = head
    while (curr != null) {
        val nextTemp = curr.next
        curr.next = prev
        prev = curr
        curr = nextTemp
    }
    return prev
}

private fun endOfFirstHalf(head: ListNode?): ListNode? {
    var fast = head
    var slow = head
    while (fast?.next != null && fast.next?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
    }
    return slow
}
