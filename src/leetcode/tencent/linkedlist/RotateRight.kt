package leetcode.tencent.linkedlist

import leetcode.ListNode

/**
 * 旋转链表
 * https://leetcode-cn.com/leetbook/read/tencent/x5pmxc/
 * @author littlecorgi
 * @date 2020/10/14
 */
fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head?.next == null) return head
    // 代表尾节点
    var oldTail = head
    var n = 1
    // 找到尾节点，顺便纪录链表长度
    while (oldTail?.next != null) {
        oldTail = oldTail.next
        n++
    }
    // 尾节点next指向头结点
    oldTail?.next = head

    var newTail = head
    for (i in 0 until n - k % n - 1) {
        newTail = newTail?.next
    }
    val newHead = newTail?.next
    newTail?.next = null
    return newHead
}
