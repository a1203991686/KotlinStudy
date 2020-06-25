package leetcode.easy

/**
 * 139. 单词拆分
 * https://leetcode-cn.com/problems/word-break/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val wordDickSet = HashSet(wordDict)
    val dp = BooleanArray(s.length + 1)
    dp[0] = true
    for (i in 1..s.length) {
        for (j in 0 until i) {
            if (dp[j] && wordDickSet.contains(s.substring(j, i))) {
                dp[i] = true
                break
            }
        }
    }
    return dp[s.length]
}