package leetcode.easy

import leetcode.TreeNode
import java.util.*

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 * @author littlecorgi
 * @date 2020/9/28
 */
fun connect2(root: TreeNode?): TreeNode? {
    if (root == null) {
        return root
    }
    val queue = LinkedList<TreeNode>()
    queue.offer(root)
    while (queue.isNotEmpty()) {
        val n = queue.size
        var last = TreeNode()
        for (i in 0 until n) {
            val temp = queue.poll()
            if (temp.left != null) {
                queue.offer(temp.left)
            }
            if (temp.right != null) {
                queue.offer(temp.right)
            }
            if (i != 0) {
                last.next = temp
            }
            last = temp
        }
    }
    return root
}
// /**
//  * 使用递归去实现
//  */
// fun connect(root: TreeNode?): TreeNode? {
//     if (root == null) {
//         return root
//     }
//     val map = HashMap<Int, ArrayList<TreeNode>>()
//     back(root, 0, map)
//     for (i in map.keys) {
//         map[i]?.let {
//             for (jIndex in it.indices) {
//                 if (jIndex != it.size - 1) {
//                     it[jIndex].next = it[jIndex + 1]
//                 }
//             }
//         }
//     }
//     return root
// }
//
// private fun back(root: TreeNode, deep: Int, map: HashMap<Int, ArrayList<TreeNode>>) {
//     if (map[deep] == null) {
//         println("null $deep ${root.`val`}")
//         map[deep] = arrayListOf(root)
//     } else {
//         println("!null $deep ${root.`val`}")
//         map[deep]?.add(root)
//     }
//     if (root.left != null) {
//         back(root.left!!, deep + 1, map)
//     }
//     if (root.right != null) {
//         back(root.right!!, deep + 1, map)
//     }
// }