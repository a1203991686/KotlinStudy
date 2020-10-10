package leetcode.one

import leetcode.ListNode

/**
 * 142. 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @author littlecorgi
 * @date 2020/10/10
 */
fun detectCycle(head: ListNode?): ListNode? {
    if (head == null) {
        return null
    }
    var slow = head
    var fast = head
    while (fast != null) {
        slow = slow?.next
        if (fast.next != null) {
            fast = fast.next?.next
        } else {
            return null
        }
        if (fast == slow) {
            var ptr = head
            while (ptr != slow) {
                ptr = ptr?.next
                slow = slow?.next
            }
            return ptr
        }
    }
    return null
}