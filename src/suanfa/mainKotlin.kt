package suanfa

import kotlinx.coroutines.*
import java.util.*
import kotlin.concurrent.thread

//fun main() {
//    println(Calendar.getInstance().time)
//    // 新协程的生命周期只受整个应用程序的生命周期限制
//    GlobalScope.launch {
//        //        delay(1000L)
//        Thread.sleep(1000L)
//        println("World")
//        println(Calendar.getInstance().time)
//    }
//
////    thread {
////        Thread.sleep(1000L)
////        println(1)
////    }
//    println("Hello,")
//    println(Calendar.getInstance().time)
////    Thread.sleep(2000L)
//    runBlocking {
//        // 但是这个表达式阻塞了主线程
//        delay(2000L)  // ……我们延迟 2 秒来保证 JVM 的存活
//    }
//    println(Calendar.getInstance().time)
//}

//fun main() = runBlocking<Unit> {
//    // 开始执行主协程
//    GlobalScope.launch {
//        // 在后台启动一个新的协程并继续
//        delay(1000L)
//        println("World!")
//    }
//    println("Hello,") // 主协程在这里会立即执行
//    delay(2000L)      // 延迟 2 秒来保证 JVM 存活
//}

//fun main() = runBlocking {
//    val job = GlobalScope.launch {
//        // 启动一个新协程并保持对这个作业的引用
//        delay(1000L)
//        println("World!")
//    }
//    println("Hello,")
//    job.join() // 等待直到子协程执行结束
//    println("Hello,")
//}

//fun main() = runBlocking {
//    // this: CoroutineScope
//    launch {
//        // 在 runBlocking 作用域中启动一个新协程
//        delay(1000L)
//        println("World!")
//    }
//    println("Hello,")
//    println("Hello,")
//}

//fun main() {
//    println("Hello,")
//    runBlocking {
//        // this: CoroutineScope
//        launch {
//            // 在 runBlocking 作用域中启动一个新协程
//            delay(1000L)
//            println("World!")
//        }
//    }
//    println("Hello,")
//}

//fun main() = runBlocking {
//    // this: CoroutineScope
//    launch {
//        delay(200L)
//        println("Task from runBlocking")
//    }
//
//    runBlocking {
//        // 创建一个协程作用域
//        launch {
//            delay(500L)
//            println("Task from nested launch")
//        }
//
//        delay(100L)
//        println("Task from coroutine scope") // 这一行会在内嵌 launch 之前输出
//    }
//
//    println("Coroutine scope is over") // 这一行在内嵌 launch 执行完毕后才输出
//}


//fun main() = runBlocking {
//    launch { doWorld() }
//    println("Hello,")
//}
//
//// 这是你的第一个挂起函数
//suspend fun doWorld() {
//    delay(1000L)
//    println("World!")
//}

//fun main() = runBlocking {
//    repeat(100_000) { // 启动大量的协程
//        launch {
//            delay(1000L)
//            print(".")
//        }
//    }
//}

fun main() = runBlocking {
    GlobalScope.launch {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L) // 在延迟后退出
}