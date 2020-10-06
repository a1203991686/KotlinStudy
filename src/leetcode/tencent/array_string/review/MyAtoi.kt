package leetcode.tencent.array_string.review

/**
 * 字符串转换整数 (atoi)
 * https://leetcode-cn.com/leetbook/read/tencent/xxgggc/
 * @author littlecorgi
 * @date 2020/10/6
 */
// 状态机
fun myAtoi(s: String): Int {
    val automaton = Automaton()
    val length = s.length
    for (i in 0 until length) {
        automaton.get(s[i])
    }
    return (automaton.sign * automaton.ans).toInt()
}

private class Automaton {
    var sign = 1
    var ans = 0L
    private var state = "start"
    private val table = hashMapOf(
        "start" to arrayOf("start", "signed", "in_number", "end"),
        "signed" to arrayOf("end", "end", "in_number", "end"),
        "in_number" to arrayOf("end", "end", "in_number", "end"),
        "end" to arrayOf("end", "end", "end", "end")
    )

    fun get(c: Char) {
        state = table[state]?.get(getCol(c))!!
        if ("in_number" == state) {
            ans = ans * 10L + (c - '0')
            ans = if (sign == 1) Math.min(ans, Int.MAX_VALUE.toLong()) else Math.min(ans, -Int.MIN_VALUE.toLong())
        } else if (state == "signed") {
            sign = if (c == '+') 1 else -1
        }
    }

    private fun getCol(c: Char): Int {
        if (c == ' ') {
            return 0
        }
        if (c == '+' || c == '-') {
            return 1
        }
        if (Character.isDigit(c)) {
            return 2
        }
        return 3
    }
}

// 暴力解法
// fun myAtoi(s: String): Int {
//     val str = s.trim()
//     if (str == "") {
//         return 0
//     }
//     if (str.length == 1) {
//         return if (str[0].isDigit()) {
//             str.toInt()
//         } else {
//             0
//         }
//     }
//     if (((str[0] == '-' || str[0] == '+') && !str[1].isDigit())) {
//         // -+12
//         return 0
//     }
//     if (str[0] != '-' && str[0] != '+' && !str[0].isDigit()) {
//         // words and 987
//         return 0
//     }
//     val sb = StringBuilder()
//     for (i in str.indices) {
//         if (((str[i] == '-' || str[i] == '+') && sb.isEmpty() && str[i + 1].isDigit()) || (str[i].isDigit())) {
//             sb.append(str[i])
//         } else {
//             break
//         }
//     }
//     return try {
//         sb.toString().toInt()
//     } catch (e: NumberFormatException) {
//         if (sb[0] == '-') {
//             Int.MIN_VALUE
//         } else {
//             Int.MAX_VALUE
//         }
//     }
// }