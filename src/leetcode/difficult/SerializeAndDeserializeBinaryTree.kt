package leetcode.difficult

import leetcode.TreeNode
import java.lang.StringBuilder
import java.util.*

/**
 * Notion: 此题只能用Java
 *
 * 297. 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Codec() {
    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        return rSerialize(root, "")
    }

    private fun rSerialize(root: TreeNode?, str: String): String {
        var sb = StringBuilder(str)
        if (root == null) {
            sb.append("None,")
        } else {
            sb.append(root.`val`, ",")
            sb = StringBuilder(rSerialize(root.left, sb.toString()))
            sb = StringBuilder(rSerialize(root.right, sb.toString()))
        }
        return sb.toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val dataArray = data.split(",")
        val dataList = LinkedList<String>(dataArray.toList())
        return rDeserialize(dataList)
    }

    private fun rDeserialize(l: List<String>): TreeNode? {
        var m = l.toMutableList()
        if (l[0] == "None") {
            return null
        }
        val root = TreeNode(l[0].toInt())
        m.removeAt(0)
        root.left = rDeserialize(m)
        root.right = rDeserialize(m)
        return root
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var obj = Codec()
 * var data = obj.encode(longUrl)
 * var ans = obj.decode(data)
 */