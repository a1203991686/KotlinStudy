package kotlinstudy


interface Expr

class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr {
    var name: String = ""
        set(_name) {
            name = _name
        }
        get() = field
}

fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
        else ->
            throw IllegalArgumentException("Unknown expression")
    }

fun main() {
    strLen(null)
    val a = 1
    println(a as Double)
    val b = arrayOfNulls<Int>(1)
    val nullsArrayList = ArrayList<Int?>()
}

fun strLen(s: String?) = s?.let {
    it.trim()
    it.length
}
