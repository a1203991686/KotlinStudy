package leetcode.one

/**
 * 974. 和可被 K 整除的子数组
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun subarraysDivByK(A: IntArray, K: Int): Int {
    val record = HashMap<Int, Int>()
    record[0] = 1
    var sum = 0
    var ans = 0
    for (elem in A) {
        sum += elem
        val modulus = (sum % K + K) % K
        val same = record.getOrDefault(modulus, 0)
        ans += same
        record[modulus] = same + 1
    }
    return ans
}

fun main() {
    val a = intArrayOf(4, 5, 0, -2, -3, 1)
    println(subarraysDivByK(a, 5))
}