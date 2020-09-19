package coroutinetest.capture5

/**
 *
 * @author littlecorgi
 * @date 2020/9/18
 */
// interface Job : CoroutineContext.Element {
//     companion object Key : CoroutineContext.Key<Job>
//
//     override val key: CoroutineContext.Key<*>
//         get() = Job
//
//     val isActive: Boolean
//
//     fun invokeOnCancel(onCancel: OnCancel): MediaDisposer.Disposable
//
//     fun invokeOnCompletion(onComplete: OnComplete): MediaDisposer.Disposable
//
//     fun cancel()
//
//     fun remove(disposable: MediaDisposer.Disposable)
//
//     suspend fun join()
// }
//
// sealed class CoroutineState {
//     class Incomplete : CoroutineState()
//     class Cancelling : CoroutineState()
//     class Complete<T>(val value: T? = null, val exception: Throwable? = null) : CoroutineState()
//
//     protected val state = AtomicReference<CoroutineState>()
//
//
// }