package coroutinetest

import kotlin.coroutines.*

/**
 *
 * @author littlecorgi
 * @date 2020/9/17
 */
suspend fun level_0() {
    println("I'm in level 0!")
    level_1()
}

suspend fun level_1() {
    println("I'm in level 1!")
    suspendNow()
}

suspend fun suspendNow() = suspendCoroutine<Unit> {
    println(1)
}

val continuationCreate = suspend {
    println("In Coroutine.")
    5
}.createCoroutine(object : Continuation<Int> {
    override val context = EmptyCoroutineContext

    override fun resumeWith(result: Result<Int>) {
        println("Coroutine End: $result")
    }
})

val continuationStart = suspend {
    println("In Coroutine.")
    5
}.startCoroutine(object : Continuation<Int> {
    override val context = EmptyCoroutineContext

    override fun resumeWith(result: Result<Int>) {
        println("Coroutine End: $result")
    }
})

suspend fun main() {
    continuationCreate.resume(Unit)
    continuationStart
}