package leetcode.tencent.linkedlist

import leetcode.ListNode

/**
 * 删除链表中的节点
 * https://leetcode-cn.com/leetbook/read/tencent/x5ns1j/
 * @author littlecorgi
 * @date 2020/10/15
 */
fun deleteNode(node: ListNode?) {
    if (node == null) {
        return
    }
    node.`val` = node.next!!.`val`
    node.next = node.next!!.next
}