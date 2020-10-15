package leetcode.easy

import leetcode.TreeNode

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * @author littlecorgi
 * @date 2020/10/15
 */
fun connect(root: TreeNode?): TreeNode? {
    if (root == null) {
        return root
    }
    val deepList = ArrayList<ArrayList<TreeNode>>()
    deepOrder(deepList, root, 0)
    for (i in deepList) {
        for (j in 0 until i.size - 1) {
            i[j].next = i[j + 1]
        }
    }
    return root
}

private fun deepOrder(deepList: ArrayList<ArrayList<TreeNode>>, root: TreeNode?, deep: Int) {
    if (root == null) {
        return
    }
    if (deepList.size == deep) {
        deepList.add(arrayListOf(root))
    } else {
        deepList[deep].add(root)
    }
    deepOrder(deepList, root.left, deep + 1)
    deepOrder(deepList, root.right, deep + 1)
}
