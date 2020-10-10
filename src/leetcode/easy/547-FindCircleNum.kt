package leetcode.easy

/**
 * 547. 朋友圈
 * https://leetcode-cn.com/problems/friend-circles/
 *  更优解是直接使用深搜或者广搜
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun findCircleNum(M: Array<IntArray>): Int {
    val arrayList = ArrayList<ArrayList<Int>>()
    for (i in M.indices) {
        for (j in M[i].indices) {
            if (M[i][j] == 1) {
                M[j][i] = 0
                // i、j所在的集合的位置，如果是-1就证明没有
                var iIndex = -1
                var jIndex = -1
                // 找到i、j分别在哪个集合中
                for (k in arrayList.indices) {
                    if (arrayList[k].contains(i)) {
                        iIndex = k
                    }
                    if (arrayList[k].contains(j)) {
                        jIndex = k
                    }
                }
                // 开始对应的操作
                if (iIndex == -1 && jIndex == -1) {
                    // i和j都不在某个集合中，就单独开一个集合，把ij添加进去
                    val tempArrayList = ArrayList<Int>()
                    tempArrayList.add(i)
                    tempArrayList.add(j)
                    arrayList.add(tempArrayList)
                } else if (iIndex == -1 && jIndex != -1) {
                    // i不在，j在，把i添加到j的集合中去
                    arrayList[jIndex].add(i)
                } else if (iIndex != -1 && jIndex == -1) {
                    // i在，j不再，把就添加到i的集合中去
                    arrayList[iIndex].add(j)
                } else {
                    // i、j都在集合中
                    if (iIndex == jIndex) {
                        // ij在同一个集合中，不做任何操作
                        continue
                    } else {
                        // ij不在同一个集合，两个集合合并
                        // 默认将j所在的集合添加到i所在的集合中去
                        arrayList[iIndex].add(arrayList[jIndex])
                        arrayList.removeAt(jIndex)
                    }
                }
            }
        }
    }
    return arrayList.size
}

fun <E> ArrayList<E>.add(array: ArrayList<E>) {
    for (i in array) {
        this.add(i)
    }
}
