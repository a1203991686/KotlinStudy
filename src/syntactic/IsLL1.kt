package syntactic

/**
 *
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */

fun getGrammarFirst(s: String): MutableSet<Char> {
    val set = LinkedHashSet<Char>()
    if (s[0].isUpperCase()) {
        for (i in s.indices) {
            var hasEmpty = false
            if (s[i].isUpperCase()) {
                val upperCase = if (s[i + 1] == '\'') {
                    s.substring(i, i + 2)
                } else {
                    s.substring(i, i + 1)
                }
                for (j in first[upperCase]!!.indices) {
                    if (first[upperCase]!!.elementAt(j) != '~') {
                        set.add(first[upperCase]!!.elementAt(j))
                    } else {
                        hasEmpty = true
                    }
                }
                if (!hasEmpty) {
                    return set
                }
            } else if (s[i].isLowerCase() && hasEmpty) {
                set.add(s[i])
                return set
            } else if (s[i] == '\'') {
                continue
            } else {
                return set
            }
        }
    } else {
        set.add(s[0])
        return set
    }
    return set
}

fun isLL1(): Boolean {
    for (vn in vnSet) {
        for (i in 0 until vn.right.size) {
            for (j in i + 1 until vn.right.size) {
                if (intersect(getGrammarFirst(vn.right.elementAt(i)), getGrammarFirst(vn.right.elementAt(i)))) {
                    return false
                }
            }
        }
        // 如果存在~，则判断FIRST(A)和FOLLOW(A)有没有交集
        if (vn.right.contains("~")) {
            if (intersect(first[vn.left]!!, follow[vn.left]!!)) {
                return false
            }
        }
    }
    return true
}

// 判断a和b是否相交
fun intersect(a: MutableSet<Char>, b: MutableSet<Char>): Boolean {
    for (i in b.indices) {
        if (a.contains(b.elementAt(i))) {
            return true
        }
    }
    return false
}