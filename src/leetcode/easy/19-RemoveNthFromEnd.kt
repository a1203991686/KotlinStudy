package leetcode.easy

import leetcode.ListNode

/**
 * 19. 删除链表的倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @author littlecorgi
 * @date 2020/10/18
 */
fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var cur = head
    var tail = head
    var pre = cur
    repeat(n) {
        tail = tail?.next
    }
    while (tail != null) {
        pre = cur
        cur = cur?.next
        tail = tail?.next
    }
    if (cur == head) {
        return head?.next
    } else {
        val next = cur?.next
        pre?.next = next
    }
    return head
}
