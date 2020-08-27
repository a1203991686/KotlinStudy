package leetcode.one

import java.util.*
import kotlin.collections.HashMap

/**
 * 332. 重新安排行程
 * https://leetcode-cn.com/problems/reconstruct-itinerary/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
private val map = HashMap<String, PriorityQueue<String>>()
private val itinerary = LinkedList<String>()

fun findItinerary(tickets: List<List<String>>): List<String> {
    for (ticket in tickets) {
        val src = ticket[0]
        val dst = ticket[1]
        if (!map.containsKey(src)) {
            map[src] = PriorityQueue()
        }
        map[src]?.offer(dst)
    }
    dfs("JFK")
    itinerary.reverse()
    return itinerary
}

private fun dfs(curr: String) {
    while (map.containsKey(curr) && map[curr]?.size!! > 0) {
        val temp = map[curr]?.poll()
        dfs(temp!!)
    }
    itinerary.add(curr)
}