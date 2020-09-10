package kotlinstudy

import java.math.BigInteger
import kotlin.concurrent.thread

tailrec fun test(a: Int, b: BigInteger): BigInteger {
    if (a == 0) {
        return b
    }
    Main.print()
    return test(a - 1, BigInteger.valueOf(a.toLong()).multiply(b))
}

// fun main() {
//     // println(test(100000, BigInteger.valueOf(1.toLong())))
//     val threadA = Thread {
//         for (i in 0..4) {
//             println("A $i")
//         }
//     }
//     val threadB = Thread {
//         for (i in 0..4) {
//             println("B $i")
//         }
//     }
//     val threadC = Thread {
//         for (i in 0..4) {
//             println("C $i")
//         }
//     }
//     val a: Double = 3.3
//     val b: Double = 1.0
//     println(a.toInt())
//     println(a * b)
//     val c = a.to(b)
// }

object Main {
    var a: String = "1"

    fun print() {

    }
}

class MainTest {
    companion object {
        var a: String = "1"
        fun print() {

        }
    }
}

inline fun hello(a: Int,  b: () -> Int) {
    println("hello")
    println(b())
}

fun main1(): Int {
    hello(1) {
        println("abc")
        return 1
    }
    return 2
}

fun main() {
    println("main: ${main1()}")
}
