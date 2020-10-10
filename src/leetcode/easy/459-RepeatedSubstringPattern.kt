package leetcode.easy

/**
 * 459. 重复的子字符串
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun repeatedSubstringPattern(s: String): Boolean {
    return (s + s).indexOf(s, 1) != s.length
}
