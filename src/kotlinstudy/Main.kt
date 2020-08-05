package kotlinstudy

import java.math.BigInteger

tailrec fun test(a: Int, b: BigInteger): BigInteger {
    if (a == 0) {
        return b
    }
    Main.print()
    return test(a - 1, BigInteger.valueOf(a.toLong()).multiply(b))
}

fun main() {
    println(test(100000, BigInteger.valueOf(1.toLong())))
}

object Main {
    var a: String = "1"

    fun print() {

    }
}

class MainTest {
    companion object {
        var a : String = "1"
        fun print() {

        }
    }
}