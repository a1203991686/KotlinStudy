package leetcode.easy

import java.util.*

/**
 * 394. 字符串解码
 * https://leetcode-cn.com/problems/decode-string/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
class Solution {
    var ptr = 0
    fun decodeString(s: String): String {
        val stk = LinkedList<String?>()
        ptr = 0
        while (ptr < s.length) {
            val cur = s[ptr]
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
                val digits = getDigits(s)
                stk.addLast(digits)
            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取一个字母并进栈
                stk.addLast(s[ptr++].toString())
            } else {
                ++ptr
                val sub = LinkedList<String?>()
                while ("[" != stk.peekLast()) {
                    sub.addLast(stk.removeLast())
                }
                sub.reverse()
                // 左括号出栈
                stk.removeLast()
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                var repTime = stk.removeLast()!!.toInt()
                val t = StringBuffer()
                val o = getString(sub)
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o)
                }
                // 将构造好的字符串入栈
                stk.addLast(t.toString())
            }
        }
        return getString(stk)
    }

    fun getDigits(s: String): String {
        val ret = StringBuffer()
        while (Character.isDigit(s[ptr])) {
            ret.append(s[ptr++])
        }
        return ret.toString()
    }

    fun getString(v: LinkedList<String?>): String {
        val ret = StringBuffer()
        for (s in v) {
            ret.append(s)
        }
        return ret.toString()
    }
}