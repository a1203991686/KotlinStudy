package leetcode.easy

/**
 * 96. 不同的二叉搜索树
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun numTrees(n: Int): Int {
    val G = IntArray(n + 1)
    G[0] = 1
    G[1] = 1
    for (i in 2..n) {
        for (j in 1..i) {
            G[i] += G[j - 1] * G[i - j]
        }
    }
    return G[n]
}