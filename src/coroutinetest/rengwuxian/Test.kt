package coroutinetest.rengwuxian

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * @author littlecorgi
 * @date 2020/9/24
 */
fun main() {
    runBlocking {
        runOnUIThread1()
        runOnMainThread1()
        runOnUIThread2()
        runOnMainThread2()
    }
}

suspend fun runOnUIThread1() {
    withContext(Dispatchers.IO) {
        println(Thread.currentThread().name)
        println("I'm in UI1")
    }
}

suspend fun runOnUIThread2() {
    withContext(Dispatchers.IO) {
        println(Thread.currentThread().name)
        println("I'm in UI2")
    }
}

suspend fun runOnMainThread1() {
    withContext(Dispatchers.Default) {
        println(Thread.currentThread().name)
        println("I'm in Main1")
    }
}

suspend fun runOnMainThread2() {
    withContext(Dispatchers.Default) {
        println(Thread.currentThread().name)
        println("I'm in Main2")
    }
}