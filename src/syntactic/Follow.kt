package syntactic

/**
 *
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
/**
 * 将str1的follow集添加到str2的follow集中去
 *
 * @param
 *  str1 为要添加的follow集的终结符
 *  str2 为被添加的follow集的终结符
 */
fun append(str1: String, str2: String) {
    for (i in follow[str1]!!.indices) {
        follow[str2]!!.add(follow[str1]!!.elementAt(i))
    }
}

/**
 * 构建Follow集
 */
fun makeFollow() {
    while (true) {
        var goon = false
        // 遍历VN_set
        for (i in 0 until vnSet.size) {
            val left = vnSet[i].left
            val right = vnSet[i].right
            // 遍历right
            for (j in right.indices) {
                val it = right.elementAt(j)
                var flag = true
                // 倒着遍历right[i]的每一位
                var k = it.length - 1
                while (k >= 0) {
                    if (it[k] == '\'') { // 如果当前为'，也就是消除了左递归之后的非终结符
                        val x = vnDic[it.substring(k - 1, k + 1)]!! - 1
                        if (flag) {
                            val tt = follow[it.substring(k - 1, k + 1)]!!.size
                            append(left, it.substring(k - 1, k + 1))
                            val tt1 = follow[it.substring(k - 1, k + 1)]!!.size
                            if (tt1 > tt) {
                                goon = true
                            }
                            if (!vnSet[x].right.contains("~")) {
                                flag = false
                            }
                        }
                        // 遍历后面
                        for (l in k + 1 until it.length) {
                            if (it[l].isUpperCase()) {
                                // 如果当前为大写字母，也就是非终结符，也就是S->..UP..的类型，就将Follow(P)添加到Follow(U)中
                                val id: String = if (l != it.length - 1 && it[l + 1] == '\'') {
                                    it.substring(l, l + 2)
                                } else {
                                    it.substring(l, l + 1)
                                }
                                val from = first[id]
                                val to = follow[it.substring(k - 1, k + 1)]
                                val tt = to!!.size
                                for (m in from!!.indices) {
                                    val it1 = from.elementAt(m)
                                    if (it1 != '~') {
                                        to.add(it1)
                                    }
                                }
                                val tt1 = follow[it.substring(k - 1, k + 1)]!!.size
                                if (tt1 > tt) {
                                    goon = true
                                }
                                if (!vnSet[vnDic[id]!! - 1].right.contains("~")) {
                                    break
                                }
                            } else if (it[l] != '\'') {
                                // 如果既不是大写字母也不是'，则当前为终结符，也就是S->..Ua..的类型，则直接将a添加到Follow(U)中
                                val tt = follow[it.substring(k - 1, k + 1)]!!.size
                                follow[it.substring(k - 1, k + 1)]!!.add(it[l])
                                val tt1 = follow[it.substring(k - 1, k + 1)]!!.size
                                if (tt1 > tt) {
                                    goon = true
                                }
                                break
                            } else {
                                continue
                            }
                        }
                        k--
                    } else if (it[k].isUpperCase()) { // 如果当前为大写字母，也就是非终结符
                        val x = vnDic[it.substring(k, k + 1)]!! - 1
                        if (flag) {
                            val tt = follow[it.substring(k, k + 1)]!!.size
                            append(left, it.substring(k, k + 1))
                            if (!vnSet[x].right.contains("~"))
                                flag = false
                            val tt1 = follow[it.substring(k, k + 1)]!!.size
                            if (tt1 > tt) goon = true
                        }
                        for (l in k + 1 until it.length) {
                            if (it[l].isUpperCase()) {
                                // 如果当前为大写字母，也就是非终结符，也就是S->..UP..的类型，就将Follow(P)添加到Follow(U)中
                                val id = if (l != it.length - 1 && it[l + 1] == '\'') {
                                    it.substring(l, l + 2)
                                } else {
                                    it.substring(l, l + 1)
                                }
                                val from = first[id]
                                val to = follow[it.substring(k, k + 1)]
                                val tt = follow[it.substring(k, k + 1)]!!.size
                                for (m in from!!.indices) {
                                    if (from.elementAt(m) != '~') {
                                        to!!.add(from.elementAt(m))
                                    }
                                }
                                val tt1 = follow[it.substring(k, k + 1)]!!.size
                                if (tt1 > tt) {
                                    goon = true
                                }
                                if (!vnSet[vnDic[id]!! - 1].right.contains("~")) {
                                    break
                                }
                            } else if (it[l] != '\'') {
                                // 如果既不是大写字母也不是'，则当前为终结符，也就是S->..Ua..的类型，则直接将a添加到Follow(U)中
                                val tt = follow[it.substring(k, k + 1)]!!.size
                                follow[it.substring(k, k + 1)]!!.add(it[l])
                                val tt1 = follow[it.substring(k, k + 1)]!!.size
                                if (tt1 > tt) {
                                    goon = true
                                }
                                break
                            } else {
                                continue
                            }
                        }
                    } else {
                        flag = false
                    }
                    k--
                }
            }
        }
        if (!goon) {
            break
        }
    }
    println("****************FOLLOW集**********************")
    for ((key, value) in follow) {
        print("FOLLOW(${key})={")
        value.add('#')
        var flag = false
        for (i in value.indices) {
            if (flag) {
                print(",")
            }
            print(value.elementAt(i))
            flag = true
        }
        println("}")
    }
}