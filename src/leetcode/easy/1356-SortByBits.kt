package leetcode.easy

import java.util.*

/**
 * 1356. 根据数字二进制下 1 的数目排序
 * https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/
 * @author littlecorgi
 * @date 2020/11/6
 */
fun sortByBits(arr: IntArray): IntArray {
    for (i in arr.toTypedArray()) {
        print("$i ")
    }
    println()
    val list = arr.toList()
    Collections.sort(list) { x, y ->
        val xB = get(x)
        val yB = get(y)
        println("$xB $yB")
        if (xB != yB) {
            xB - yB
        } else {
            x - y
        }
    }
    return list.toIntArray()
}

private fun get(x: Int): Int {
    var res = 0
    var x1 = x
    while (x1 != 0) {
        res += x1 % 2
        x1 /= 2
    }
    return res
}
