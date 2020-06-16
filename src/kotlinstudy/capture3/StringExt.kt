@file:JvmName("StringExt")

package kotlinstudy.capture3

import java.lang.StringBuilder

/**
 * 3.3.3 扩展函数 joinToString
 *
 * @author littlecorgi - tianweikang
 * @data 2020/03/24 15:28
 */
fun <T> Collection<T>.joinToString(
    separator: String = "",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) {
            result.append(separator)
        }

        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

open class View {
    open fun onClick() {
        println("View.onClick")
    }
}

class Button : View() {
    override fun onClick() {
        println("Button.onClick")
    }
}

fun View.show() = println("im view")
fun Button.show() = println("im button")