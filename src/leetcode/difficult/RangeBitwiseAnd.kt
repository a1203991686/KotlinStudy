package leetcode.difficult

/**
 * 201. 数字范围按位与
 * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun rangeBitwiseAnd(m: Int, n: Int): Int {
    var shift = 0
    var tempM = m
    var tempN = n
    while (tempM < tempN) {
        tempM = tempM.shr(1)
        tempN = tempN.shr(1)
        shift++
    }
    return tempM.shl(shift)
}