package leetcode.easy

import leetcode.ListNode

/**
 * 143. 重排链表
 * https://leetcode-cn.com/problems/reorder-list/
 * @author littlecorgi
 * @date 2020/10/21
 */
// 线性表实现
fun reorderList(head: ListNode?): Unit {
    if (head == null) {
        return
    }
    val list = ArrayList<ListNode>()
    var index = head
    while (index != null) {
        list.add(index)
        index = index.next
    }

    val n = list.size
    for (i in 0 until n / 2) {
        val i2 = n - i - 1
        val node1 = list[i]
        val node2 = list[i2]
        node1.next = node2
        node2.next = list[i + 1]
    }
    if (n % 2 != 0) {
        list[n / 2].next = null
    } else {
        list[n - n / 2].next = null
    }
}

fun reorderList1(head: ListNode?): Unit {
    // 先找到中间接点，使用快慢指针
    var slow = head
    var fast = head
    while (fast?.next != null && fast.next?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }
    val mid = slow

    // 对后部分链表进行链表逆序，把mid看做head
    
}