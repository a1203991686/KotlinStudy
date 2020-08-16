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
    // println(test(100000, BigInteger.valueOf(1.toLong())))
    val threadA = Thread {
        for (i in 0..4) {
            println("A $i")
        }
    }
    val threadB = Thread {
        for (i in 0..4) {
            println("B $i")
        }
    }
    val threadC = Thread {
        for (i in 0..4) {
            println("C $i")
        }
    }
    threadA.start()
    threadA.join()
    threadB.start()
    threadB.join()
    threadC.start()
}

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