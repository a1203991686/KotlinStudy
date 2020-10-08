package leetcode.tencent.array_string

/**
 * 反转字符串中的单词 III
 * https://leetcode-cn.com/leetbook/read/tencent/xxjfdd/
 * @author littlecorgi
 * @date 2020/10/8
 */
fun reverseWords(s: String): String {
    val str = s.trim()
    val strList = str.split(" ").toMutableList()
    for (i in strList.indices) {
        val temp = strList[i].reversed()
        strList[i] = temp
    }
    val sb = StringBuilder()
    for (i in strList.indices) {
        if (i == strList.size - 1) {
            sb.append(strList[i])
            break
        }
        sb.append("${strList[i]} ")
    }
    return sb.toString()
}
