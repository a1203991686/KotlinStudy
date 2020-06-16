package syntactic

import java.util.LinkedHashMap

/**
 *
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
/**
 * 检查一个字符是否属于一个字符串的First集
 */
fun checkFirst(text: String, ch: Char): Boolean {
    // println("checkFirst: text=\"${text}\" ch=\"${ch}\"")
    for (i in text.indices) {
        var hasEmpty = false
        if (!text[i].isUpperCase() && text[i] != '\'') {
            return text[i] == ch
        } else if (text[i].isUpperCase()) {
            val temp = if (i != text.length - 1 && text[i + 1] == '\'') {
                text.substring(i, i + 2)
            } else {
                text.substring(i, i + 1)
            }
            val dic = first[temp]
            for (j in dic!!.indices) {
                if (dic.elementAt(j) == '~') {
                    hasEmpty = true
                }
                if (dic.elementAt(j) == ch) {
                    return true
                }
            }
            if (!hasEmpty) {
                break
            }
        } else {
            continue
        }
    }
    return false
}

/**
 * 检查一个字符是否属于一个字符串的Follow集
 */
fun checkFollow(text: String, ch: Char): Boolean {
    val dic = follow[text]
    for (i in dic!!.indices) {
        if (dic.elementAt(i) == ch) {
            return true
        }
    }
    return false
}

/**
 * 构建预测分析表
 */
fun makeTable() {
    val letter = ArrayList<Char>()
    val vis = BooleanArray(500) {
        false
    }
    // println("vis: ${vis.size}")
    // for (i in vis.indices) {
    //     print("${vis[i]},")
    // }
    // println()
    // 遍历vnSet
    // 主要目的是得到所有的终结符
    for (i in vnSet.indices) {
        // 获取当前的非终结符的右部
        val right = vnSet[i].right
        // 遍历right
        for (j in right.indices) {
            val it = right.elementAt(j)
            for (k in it.indices) {
                if (!it[k].isUpperCase() && it[k] != '\'') {
                    if (vis[it[k].toInt()]) {
                        continue
                    }
                    vis[it[k].toInt()] = true
                    letter.add(it[k])
                }
            }
        }
    }
    // 再次遍历vnSet
    // 此时已经拿到了所有的终结符，所以此时可以构建预测分析表
    for (i in vnSet.indices) {
        val temp = LinkedHashMap<Char, String>()
        val left = vnSet[i].left
        val right = vnSet[i].right
        // 遍历right
        for (j in right.indices) {
            val it = right.elementAt(j)
            // 遍历每一个终结符
            for (k in letter.indices) {
                // 对于FIRST(α)中的每个终结符号a，将A -> α加入到M[A , a]中。
                if (checkFirst(it, letter[k])) {
                    // println("checkFirst")
                    temp[letter[k]] = it
                }
                // 如果ε在FIRST(α)中，那么对于FOLLOW(A)中的每个终结符号b，将A-α加入到M[A,b]中。
                if (checkFollow(left, letter[k]) && it[0] == '~') {
                    temp[letter[k]] = it
                }
            }
        }
        predictTable.add(temp)
        // println("将temp添加到predictTable：$temp")
    }
    // println("Log: ")
    // println(letter.toString())
    // println(predictTable.toString())
    TablePrint.printTable(letter, vnSet, predictTable)
}