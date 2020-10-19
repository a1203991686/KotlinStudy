package leetcode.easy

/**
 *
 * @author littlecorgi
 * @date 2020/10/19
 */
fun backspaceCompare(S: String, T: String): Boolean {
    val sbA = StringBuilder()
    for (i in S) {
        if (i != '#') {
            sbA.append(i)
        } else if (sbA.isNotEmpty()) {
            sbA.deleteCharAt(sbA.lastIndex)
        }
    }
    val resultS = sbA.toString()
    sbA.clear()
    for (i in T) {
        if (i != '#') {
            sbA.append(i)
        } else if (sbA.isNotEmpty()) {
            sbA.deleteCharAt(sbA.lastIndex)
        }
    }
    val resultT = sbA.toString()
    return resultS == resultT
}
