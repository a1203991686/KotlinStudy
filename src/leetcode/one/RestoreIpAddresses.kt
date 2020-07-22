package leetcode.one

import java.util.*
import kotlin.collections.ArrayList

/**
 * 93. 复原IP地址
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */

var n = 0
var str = ""
var segments = LinkedList<String>()
var output = ArrayList<String>()

fun restoreIpAddresses(s: String): List<String> {
    n = s.length
    str = s
    backtrack(-1, 3)
    return output
}

fun backtrack(prev_pos: Int, dots: Int) {
    val max_pos = Math.min(n - 1, prev_pos + 4)
    for (curr_pos in (prev_pos + 1) until max_pos) {
        val segment = str.substring(prev_pos + 1, curr_pos + 1)
        if (valid(segment)) {
            segments.add(segment)
            if (dots - 1 == 0) {
                update_output(curr_pos)
            } else {
                backtrack(curr_pos, dots - 1)
            }
            segments.removeLast()
        }
    }
}

fun valid(segment: String): Boolean {
    val m = segment.length
    if (m > 3) {
        return false
    }
    return if (segment[0] != '0') (segment.toInt() <= 255) else m == 1
}

fun update_output(curr_pos: Int) {
    val segment = str.substring(curr_pos + 1, n)
    if (valid(segment)) {
        segments.add(segment)
        output.add(segments.joinToString(separator = "."))
        segments.removeLast()
    }
}