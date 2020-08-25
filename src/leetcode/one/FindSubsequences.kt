package leetcode.one

/**
 * 491. 递增子序列
 * https://leetcode-cn.com/problems/increasing-subsequences/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
private val temp = ArrayList<Int>()
private val ans = ArrayList<List<Int>>()
private val set = HashSet<Int>()
private var n = 0

fun findSubsequences(nums: IntArray): List<List<Int>> {
    n = nums.size
    for (i in 0 until 1.shl(n)) {
        findSubsequences(i, nums)
        val hashValue = getHash(263, (1E9 + 7).toInt())
        if (check() && !set.contains(hashValue)) {
            print("temp被添加：")
            for (j in temp) {
                print("$j ")
            }
            println()
            ans.add(ArrayList<Int>(temp))
            set.add(hashValue)
        }
    }
    return ans
}

private fun findSubsequences(mask: Int, nums: IntArray) {
    temp.clear()
    var maskTemp = mask
    for (i in 0 until n) {
        println("maskTemp: $maskTemp")
        if ((maskTemp.and(1)) != 0) {
            temp.add(nums[i])
        }
        maskTemp = maskTemp.shr(1)
    }
    print("temp: ")
    for (i in temp) {
        print("$i ")
    }
    println()
}

private fun getHash(base: Int, mod: Int): Int {
    var hashValue = 0
    for (x in temp) {
        hashValue = hashValue * base % mod + (x + 101)
        hashValue %= mod
    }
    return hashValue
}

private fun check(): Boolean {
    for (i in 1 until temp.size) {
        if (temp[i] < temp[i - 1]) {
            return false
        }
    }
    return temp.size >= 2
}
