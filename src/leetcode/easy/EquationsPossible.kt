package leetcode.easy

import java.lang.StringBuilder

/**
 * 990. 等式方程的可满足性
 * https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun equationsPossible(equations: Array<String>): Boolean {
    val equals = ArrayList<StringBuilder>()
    for (str in equations) {
        if (str[1] == '=') {
            val tempList = str.split("==")
            val a = tempList[0]
            val b = tempList[1]
            if (a == b) {
                continue
            }
            var hasAIndex = -1
            var hasBIndex = -1
            for (i in equals.indices) {
                if (equals[i].contains(a)) {
                    hasAIndex = i
                }
                if (equals[i].contains(b)) {
                    hasBIndex = i
                }
            }
            if (hasAIndex != hasBIndex) {
                if (hasAIndex != -1 && hasBIndex != -1) {
                    equals[hasAIndex].append(equals[hasBIndex])
                    equals.remove(equals[hasBIndex])
                } else if (hasAIndex != -1 && hasBIndex == -1) {
                    equals[hasAIndex].append(b)
                } else if (hasBIndex != -1 && hasAIndex == -1) {
                    equals[hasBIndex].append(a)
                }
            } else if (hasAIndex == -1) {
                equals.add(StringBuilder(a + b))
            }
        }
    }
    for (str in equations) {
        if (str[1] == '!') {
            val tempList = str.split("!=")
            val a = tempList[0]
            val b = tempList[1]
            if (a == b) {
                return false
            }
            var hasAIndex = -1
            var hasBIndex = -1
            for (i in equals.indices) {
                if (equals[i].contains(a)) {
                    hasAIndex = i
                }
                if (equals[i].contains(b)) {
                    hasBIndex = i
                }
            }
            if (hasAIndex == hasBIndex) {
                if (hasAIndex == -1) {
                    continue
                } else {
                    return false
                }
            }
        }
    }
    return true
}