package leetcode.easy

/**
 * 925. 长按键入
 * https://leetcode-cn.com/problems/long-pressed-name/
 * @author littlecorgi
 * @date 2020/10/21
 */
fun isLongPressedName(name: String, typed: String): Boolean {
    var i = 0
    var j = 0
    while (i < name.length && j < typed.length) {
        if (name[i]
            == typed[j]
        ) {
            i++
            j++
            continue
        }
        if (j > 0 && typed[j] == typed[j - 1]) {
            j++
            continue
        }
        if (name[i] != typed[j]) {
            println("i=$i j=$j")
            return false
        }
    }
    while (j < typed.length) {
        if (typed[j] == typed[j - 1]) {
            j++
        } else {
            break
        }
    }
    if (i != name.length || j != typed.length) {
        println("i=$i j=$j")
        return false
    }
    return true
}
