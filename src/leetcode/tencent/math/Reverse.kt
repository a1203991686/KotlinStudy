package leetcode.tencent.math

/**
 * 整数反转
 * https://leetcode-cn.com/leetbook/read/tencent/x5s2oj/
 * @author littlecorgi
 * @date 2020/10/16
 */
fun reverse(x: Int): Int {
    var rev = 0
    var sum = x
    while (sum != 0) {
        val pop = sum % 10
        sum /= 10
        if (rev > Int.MAX_VALUE / 10 || (rev == Int.MAX_VALUE / 10 && pop > 7)) return 0
        if (rev < Int.MIN_VALUE / 10 || (rev == Int.MIN_VALUE / 10 && pop < -8)) return 0
        rev = rev * 10 + pop
    }
    return rev
}
