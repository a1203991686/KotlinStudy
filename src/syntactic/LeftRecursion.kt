package syntactic

/**
 *
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */

fun hasLeftRecursion(): Boolean {
    for (i in vnSet.indices) {
        val left = vnSet[i].left
        val right = vnSet[i].right
        for (j in right.indices) {
            if (right.elementAt(j).length > 1) {
                if (left == right.elementAt(j).substring(0, 2)) {
                    return true
                } else if (left == right.elementAt(j).substring(0, 1)) {
                    return true
                }
            } else if (right.elementAt(j).length == 1) {
                if (left == right.elementAt(j)) {
                    return true
                }
            }
        }
    }
    return false
}

/**
 * 消除直接左递归，即将形如A->Ab|c 的转化为 A->cA'和A'->bA'|~
 */
fun solveLeftRecursion() {
    for (i in vnSet.indices) {
        var flag = false
        var leftIndex = 0
        val left = vnSet[i].left
        val right = vnSet[i].right
        for (j in right.indices) {
            if (right.elementAt(j).length > 1) {
                if (left == right.elementAt(j).substring(0, 2)) {
                    flag = true
                    leftIndex = j
                } else if (left == right.elementAt(j).substring(0, 1)) {
                    flag = true
                    leftIndex = j
                }
            } else if (right.elementAt(j).length == 1) {
                if (left == right.elementAt(j)) {
                    flag = true
                    leftIndex = j
                }
            }
        }

        if (flag && vnSet[i].right.size == 2) {
            val newVN = vnSet[i].left + '\''

            // 将原文法改造成A->cA'
            val temp1 = vnSet[i].right.elementAt(leftIndex)
            vnSet[i].right.remove(temp1)
            val temp2 = vnSet[i].right.elementAt(0)
            vnSet[i].right.remove(temp2)
            vnSet[i].right.add(temp2 + newVN)

            // 添加A'->bA'|~
            vnSet.add(Grammar(newVN))
            val newRight = temp1.substring(1, temp1.length) + newVN
            vnDic[newVN] = vnSet.size
            val x = vnDic[newVN]!! - 1
            vnSet[x].insert(newRight)
            vnSet[x].insert("~")
        }
    }
}