package leetcode.tencent.linkedlist

import leetcode.ListNode

/**
 * 合并两个有序链表
 * https://leetcode-cn.com/leetbook/read/tencent/x59tp7/
 * @author littlecorgi
 * @date 2020/10/13
 */
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null || l2 == null) {
        return l1 ?: l2
    }
    var i = l1
    var j = l2
    val result = if (l1.`val` < l2.`val`) {
        i = i.next
        ListNode(l1.`val`)
    } else {
        j = j.next
        ListNode(l2.`val`)
    }
    var k = result
    while (i != null && j != null) {
        if (i.`val` < j.`val`) {
            val temp = ListNode(i.`val`)
            k.next = temp
            k = temp
            i = i.next
        } else {
            val temp = ListNode(j.`val`)
            k.next = temp
            k = temp
            j = j.next
        }
    }
    k.next = i ?: j
    return result
}
