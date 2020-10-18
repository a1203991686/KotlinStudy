package leetcode.tencent.math

/**
 * 2的幂
 * https://leetcode-cn.com/leetbook/read/tencent/x5yjhd/
 * @author littlecorgi
 * @date 2020/10/18
 */
fun isPowerOfTwo(n: Int): Boolean {
    if (n == 0 || n == Int.MIN_VALUE) return false
    val str = Integer.toBinaryString(n)
    for (i in 1 until str.length) {
        if (str[i] == '1') {
            return false
        }
    }
    return true
}
