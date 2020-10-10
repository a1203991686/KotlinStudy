package leetcode.easy

/**
 * 146. LRU缓存机制
 * https://leetcode-cn.com/problems/lru-cache/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
class LRUCache(private val capacity: Int) {

    val hashMap = LinkedHashMap<Int, Int>(capacity, 0.75f, true)

    fun get(key: Int): Int =
        if (hashMap.containsKey(key)) {
            hashMap[key]!!
        } else {
            -1
        }

    fun put(key: Int, value: Int) {
        if (capacity == hashMap.size && !hashMap.containsKey(key)) {
            for ((k, _) in hashMap) {
                hashMap.remove(k)
                break
            }
        }
        hashMap[key] = value
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

fun main() {
    val cache = LRUCache(2)

    println(cache.get(2))
    println(cache.hashMap)
    println(cache.get(2))
    println(cache.hashMap)
    cache.put(2, 6)
    println(cache.get(1))
    println(cache.hashMap)
    cache.put(1, 5)
    cache.put(1, 2)
    println(cache.get(1))
    println(cache.hashMap)
    println(cache.get(2))
    println(cache.hashMap)


    // cache.put(1, 1)
    // cache.put(2, 2)
    // println(cache.get(1))     // 返回  1
    // println(cache.hashMap)
    // cache.put(3, 3)// 该操作会使得密钥 2 作废
    // println(cache.get(2))   // 返回 -1 (未找到)
    // println(cache.hashMap)
    // cache.put(4, 4)   // 该操作会使得密钥 1 作废
    // println(cache.get(1))   // 返回 -1 (未找到)
    // println(cache.hashMap)
    // println(cache.get(3))     // 返回  3
    // println(cache.hashMap)
    // println(cache.get(4))     // 返回  4
    // println(cache.hashMap)

}