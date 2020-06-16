package kotlinstudy.capture2

/**
 *
 * 2.3.7
 *
 * @author littlecorgi - tianweikang
 * @data 2020/03/23 11:33
 */

interface Expr

class Num(val value: Int) : Expr

class Sum(val left: Expr, val right: Expr) :
    Expr

fun main() {
    println(
        eval(
            Sum(
                Sum(
                    Num(1),
                    Num(2)
                ), Num(3)
            )
        )
    )
}

fun eval(e: Expr): Int =
    when (e) {
        is Sum -> {
            eval(e.left) + eval(e.right)
        }
        is Num -> {
            e.value
        }
        else -> {
            throw IllegalArgumentException("Unknown expression")
        }
    }
