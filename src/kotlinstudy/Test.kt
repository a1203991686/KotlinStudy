package kotlinstudy

import java.util.*

/**
 *
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun main() {
    val c = ListNode(0)
    val b = ListNode(1)
    b.next = c
    val a = ListNode(2)
    a.next = b
    var result = reverse(a)
    while (result != null) {
        println(result.`val`)
        result = result.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun reverse(root: ListNode?): ListNode? {
    var pre: ListNode? = null
    var cur = root
    var temp: ListNode? = null
    while (cur != null) {
        // 纪录下当前的节点的下一个节点，因为我们反转之后cur指向的是pre了
        temp = cur.next
        // 修改指针
        cur.next = pre
        pre = cur
        cur = temp
    }
    return pre
}