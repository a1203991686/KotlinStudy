package leetcode.one

/**
 * 763. 划分字母区间
 * https://leetcode-cn.com/problems/partition-labels/
 * @author littlecorgi
 * @date 2020/10/22
 */
fun partitionLabels(S: String): List<Int> {
    val last = IntArray(26)
    val length = S.length
    for (i in 0 until length) {
        last[S[i] - 'a'] = i
    }
    val partition = ArrayList<Int>()
    var start = 0
    var end = 0
    for (i in 0 until length) {
        end = Math.max(end, last[S[i] - 'a'])
        if (i == end) {
            partition.add(end - start + 1)
            start = end + 1
        }
    }
    return partition
}
