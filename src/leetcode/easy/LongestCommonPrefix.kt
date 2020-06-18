package leetcode.easy

/**
 * 14. 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) {
        return ""
    }
    val prefix = StringBuilder()
    var index = 0
    try {
        while (true) {
            val set = HashSet<Char>()
            set.add(strs[0][index])
            for (i in strs) {
                if (!set.contains(i[index])) {
                    return prefix.toString()
                }
            }
            prefix.append(strs[0][index])
            index++
        }
    } catch (e: StringIndexOutOfBoundsException) {
    }
    return prefix.toString()
}

fun longestCommonPrefix1(strs: Array<String>): String {
    if (strs.isEmpty()) {
        return ""
    }
    var right = strs[0].length
    for (i in 1 until strs.size) {
        try {
            for (j in strs[0].substring(0, right).indices) {
                if (strs[0].substring(0, right)[j] != strs[i][j]) {
                    right = j
                    break
                }
                if (j > right) {
                    break
                }
            }
        } catch (e: StringIndexOutOfBoundsException) {
            right = strs[i].length
        }
    }
    return strs[0].substring(0, right)
}