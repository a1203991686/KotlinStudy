package leetcode

/**
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
class TreeNode() {
    constructor(a: Int) : this() {
        this.`val` = a
    }

    var `val`: Int = 0
    var left: TreeNode? = null
    var right: TreeNode? = null
    /**
     * next是为了适应 LC-116 题这种带next指针的情景
     * 116. 填充每个节点的下一个右侧节点指针
     * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
     */
    var next: TreeNode? = null
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}

/**
 * 返回如下一棵二叉树
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
fun getBinaryTree(): TreeNode {
    val root = TreeNode(3)
    val a = TreeNode(9)
    val b = TreeNode(20)
    val c = TreeNode(15)
    val d = TreeNode(7)
    root.left = a
    root.right = b
    b.left = c
    b.right = d
    return root
}

fun getLinkedList(flag: Boolean): ListNode? {
    return if (flag) {
        val a = ListNode(4)
        val b = ListNode(1)
        val c = ListNode(8)
        val d = ListNode(4)
        val e = ListNode(5)
        a.next = b
        b.next = c
        c.next = d
        d.next = e
        e.next = null
        a
    } else {
        val a = ListNode(5)
        val b = ListNode(0)
        val c = ListNode(1)
        val d = ListNode(8)
        val e = ListNode(4)
        val f = ListNode(5)
        a.next = b
        b.next = c
        c.next = d
        d.next = e
        e.next = f
        f.next = null
        a
    }
}