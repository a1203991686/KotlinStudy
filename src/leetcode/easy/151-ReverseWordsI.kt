package leetcode.easy

import java.util.regex.Pattern

/**
 * 151. 翻转字符串里的单词
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun reverseWords(s: String): String {
    val strArray = s.trim().split(Pattern.compile("\\s+"))
    val reversedStrArray = strArray.reversed()
    return reversedStrArray.toSentence()
}

fun List<String>.toSentence(): String {
    val sb = StringBuilder()
    for (i in this) {
        sb.append("$i ")
    }
    return sb.toString().trim()
}