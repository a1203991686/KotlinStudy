package leetcode.easy

import leetcode.ListNode

/**
 * 24. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @author littlecorgi
 * @date 2020/10/13
 */
fun swapPairs(head: ListNode?): ListNode? {
    val result = if (head?.next != null) head.next else head
    var pre = head
    var cur = pre?.next
    var next = cur?.next
    while (pre != null && cur != null) {
        // 交换节点指针
        cur.next = pre
        pre.next = if (next?.next != null) next.next else next

        pre = next
        cur = pre?.next
        next = cur?.next
    }
    return result
}