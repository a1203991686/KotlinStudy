package coroutinetest.capture5

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
 * 实现协程的 delay 函数
 * @author littlecorgi
 * @date 2020/9/18
 */
private val executor = Executors.newScheduledThreadPool(1) {
    Thread(it, "Scheduler").apply { isDaemon = true }
}

suspend fun delay(time: Long, unit: TimeUnit = TimeUnit.MILLISECONDS) {
    // 如果传入的参数不规范，直接返回即可
    if (time <= 0) {
        return
    }
    // 内部通过一个线程池去延迟 time 之后调用协程的 resume 去终止该协程
    suspendCoroutine<Unit> { continuation ->
        executor.schedule({ continuation.resume(Unit) }, time, unit)
    }
}