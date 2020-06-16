package syntactic

/**
 *
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
class Grammar(s: String) {
    // 文法的左部分
    val left = s

    // 文法的右部分
    val right = mutableSetOf<String>()

    fun print() {
        print("${left}->")
        if (right.isNotEmpty()) {
            print(right.elementAt(0))
        }
        for (i in 1 until right.size) {
            print("|${right.elementAt(i)}")
        }
    }

    fun insert(s: String) {
        right.add(s)
    }
}