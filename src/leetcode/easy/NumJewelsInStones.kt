package leetcode.easy

/**
 * 771. 宝石与石头
 * https://leetcode-cn.com/problems/jewels-and-stones/
 * @author littlecorgi
 * @date 2020/10/2
 */
fun numJewelsInStones(J: String, S: String): Int {
    val list = J.toList()
    var result = 0
    for (i in S) {
        if (list.contains(i)) {
            result++
        }
    }
    return result
}
