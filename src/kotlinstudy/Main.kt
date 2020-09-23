package kotlinstudy

import java.math.BigInteger

tailrec fun test(a: Int, b: BigInteger): BigInteger {
    if (a == 0) {
        return b
    }
    return test(a - 1, BigInteger.valueOf(a.toLong()).multiply(b))
}

fun main() {
    // val thread = Thread {
    //     for (i in 0..10) {
    //         println("子线程 $i")
    //     }
    // }
    // thread.start()
    //
    // for (i in 0..10) {
    //     println("主线程 $i")
    //     if (i > 2) {
    //         thread.join()
    //     }
    // }
    repeat(250) {
        val mainThread = MainThread()
        mainThread.start()
        Thread {
            MainRunnable()
        }.start()
    }
    val arrayList = ArrayList<Int>()
    repeat(100) {
        arrayList.add(0)
    }
    for (i in 0..99) {
        arrayList.add(i + 1)
    }
    Thread {
        try {
            val it = arrayList.iterator()
            while (it.hasNext()) {
                print(it.next())
            }
        } catch (e: ConcurrentModificationException) {
            e.printStackTrace()
        }
    }.start()
    Thread {
        arrayList.add(3)
    }.start()
}

internal class MainThread : Thread() {
    override fun run() {
        super.run()
        println("王埃及是傻逼")
        println(currentThread().name)
    }
}

internal class MainRunnable : Runnable {
    override fun run() {
        println("王埃及是智障")
        println(Thread.currentThread().name)
    }
}