package leetcode.one

import leetcode.ListNode
import leetcode.TreeNode

/**
 * 109. 有序链表转换二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
private var globalHead: ListNode? = null

fun sortedListToBST(head: ListNode?): TreeNode? {
    globalHead = head
    val length = getLength(head)
    return buildTree(0, length - 1)
}

fun getLength(head: ListNode?): Int {
    var ret = 0
    var temp = head
    while (temp != null) {
        ret++
        temp = temp.next
    }
    return ret
}

fun buildTree(left: Int, right: Int): TreeNode? {
    if (left > right) {
        return null
    }
    val mid = (left + right + 1) / 2
    val root = TreeNode()
    root.left = buildTree(left, mid - 1)
    root.`val` = globalHead!!.`val`
    globalHead = globalHead?.next
    root.right = buildTree(mid + 1, right)
    return root
}