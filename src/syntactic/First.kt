package syntactic

/**
 *
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */

/**
 * 使用深搜算法去计算first集
 *
 * @param x {@code Int} 代表当前的非终结符在vnSet中的位置
 */
fun dfs(x: Int) {
    // 判断是否已经分析过，如果已经分析过，则跳过
    if (used[x] == true) {
        return
    }
    // 如果之前没有分析过，则将used值为true
    used[x] = true
    val left = vnSet[x].left
    // println("dfs()-> left: $left")
    val right = vnSet[x].right
    // println("dfs()-> right: $right")
    // 遍历right
    for (it in right) {
        for (j in it.indices) {
            // 如果当前的字符不是大写字符也就是不是非终结符，则直接将此字符添加到first集中
            if (!it[j].isUpperCase() && it[j] != '\'') {
                first[left]!!.add(it[j])
                // println("dfs()-> ${left}的right[$i][$j]的first[left]: ${first[left]}")
                break
            }
            // 如果当前字符是大写字符，也就是非终结符
            if (it[j].isUpperCase()) {
                val y: Int = if (j != it.length - 1 && it[j + 1] == '\'') {
                    // 如果当i不是最后一位，或者当i的后一位为字符'，所以此时的非终结符是消除了左递归的非终结符，也就是带'的
                    vnDic[it.substring(j, j + 2)]!! - 1
                } else {
                    // 否则是一位的非终结符
                    vnDic[it.substring(j, j + 1)]!! - 1
                }
                val tLeft = vnSet[y].left
                // 接着去构建y的dfs
                dfs(y)
                // 将First(y)添加到First(left)
                val temp = first[tLeft]
                var flag = true
                for (k in temp!!.indices) {
                    if (temp.elementAt(k) == '~') {
                        flag = false
                    }
                    first[left]!!.add(temp.elementAt(k))
                }
                if (flag) {
                    break
                }
            } else {
                continue
            }
        }
    }
}

/**
 * 构建First集
 */
fun makeFirst() {
    for (i in used.indices) {
        used[i] = false
    }
    for (i in vnSet.indices) {
        dfs(i)
    }
    println("****************FIRST集**********************")
    for ((key, set) in first) {
        print("FIRST(${key})={")
        var flag = false
        for (i in set.indices) {
            if (flag) {
                print(",")
            }
            print(set.elementAt(i))
            flag = true
        }
        println("}")
    }
}