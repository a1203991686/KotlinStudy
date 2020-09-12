package leetcode

/**
 * 160. 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    var a = headA
    var b = headB
    if (a == null || b == null) {
        return null
    }
    while (a != b) {
        a = if (a == null) headB else a.next
        b = if (b == null) headA else b.next
    }
    return a
}

fun main() {
    println(getIntersectionNode(getLinkedList(true), getLinkedList(false))?.`val`)
}