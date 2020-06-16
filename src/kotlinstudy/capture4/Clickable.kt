package kotlinstudy.capture4

/**
 *
 * @author littlecorgi - tianweikang
 * @data 2020/03/29 11:43
 */
interface Clickable {
    fun onClick()

    fun onShow() = println("this is click")
}

interface Focusable {
    fun onFocus()

    fun onShow() = println("this is focus")
}

class Button : Clickable, Focusable {
    override fun onClick() {
        println("onClick")
    }

    override fun onFocus() {
        println("onFocus")
    }

    override fun onShow() {
        super<Clickable>.onShow()
    }
}

fun main() {
    val button = Button()

    button.onClick()
    button.onFocus()
    button.onShow()
}