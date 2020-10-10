package leetcode.easy

import leetcode.ListNode

/**
 * 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * @author littlecorgi
 * @date 2020/10/9
 */
fun hasCycle(head: ListNode?): Boolean {
    if (head == null) {
        return false
    }
    var slow = head
    var fast = head.next
    while (slow != null && fast != null) {
        if (slow.`val` == fast.`val`) {
            return true
        }
        slow = slow.next
        fast = fast.next?.next
    }
    return false
}
