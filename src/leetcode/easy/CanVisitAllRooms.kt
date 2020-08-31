package leetcode.easy

/**
 * 841. 钥匙和房间
 * https://leetcode-cn.com/problems/keys-and-rooms/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
private lateinit var vis: BooleanArray
private var num = 0

fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
    val n = rooms.size
    num = 0
    vis = BooleanArray(n)
    dfs(rooms, 0)
    return num == n
}

private fun dfs(rooms: List<List<Int>>, x: Int) {
    vis[x] = true
    num++
    for (it in rooms[x]) {
        if (!vis[it]) {
            dfs(rooms, it)
        }
    }
}