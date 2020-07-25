package leetcode.easy

import java.lang.StringBuilder

/**
 * 60. 第k个排列
 * https://leetcode-cn.com/problems/permutation-sequence/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun getPermutation(n: Int, k: Int): String {
    val result = StringBuilder()
    var target = k
    val arrayList = ArrayList<Int>()
    var num = 1
    for (i in 1..n) {
        arrayList.add(i)
        num *= i
    }
    for (i in n downTo 1) {
        num /= i
        val a = target / num // 商
        val b = target % num // 余数
        val tempIndex = if (b == 0) a - 1 else a // 输出的ArrayList的index
        result.append(arrayList[tempIndex]) // 将结果添加进去
        arrayList.removeAt(tempIndex) // 对应的移除掉
        target = if (b == 0) num else b
    }
    return result.toString()
}
