package leetcode.easy

import leetcode.Node

/**
 * 133. 克隆图
 * https://leetcode-cn.com/problems/clone-graph/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
private val visited = HashMap<Node, Node>()
fun cloneGraph(node: Node?): Node? {
    if (node == null) {
        return node
    }
    if (visited.containsKey(node)) {
        return visited[node]
    }
    val cloneNode = Node(node.`val`)
    cloneNode.neighbors = ArrayList()
    visited[node] = cloneNode

    for (neighbor in node.neighbors) {
        cloneNode.neighbors.add(cloneGraph(neighbor))
    }
    return cloneNode
}