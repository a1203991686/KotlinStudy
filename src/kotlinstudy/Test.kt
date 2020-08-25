package kotlinstudy

import java.util.*

/**
 *
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
/**
 * 版本号比较，给定版本号v1和v2，v1>v2返回1，v1<v2返回-1，否则0，版本号由数字和.构成
如：1.7.3.1和1.8，返回-1
如：1.1.1和1.1，返回1
如：1.1和1.01，返回0
如：1.0.0和1.0，返回0
 */
fun compare(v1: String, v2: String): Int {
    val aList = v1.split('.')
    val bList = v2.split('.')
    val aLength = aList.size
    val bLength = bList.size
    var i = 0
    var j = 0
    while (i < aLength && j < bLength) {
        val aTemp = aList[i]
        val aInt = aTemp.toInt()
        val bTemp = bList[j]
        val bInt = bTemp.toInt()
        if (aInt == bInt) {
            i++
            j++
            continue
        } else if (aInt < bInt) {
            return -1
        } else {
            return 1
        }
    }
    // 证明两个完全相等
    if (i == aLength && j == bLength) {
        return 0
    } else if (i == aLength && j != bLength) {
        // 如果比较完成后，那么这个时候就证明前面的值都相等，但是a没有剩下的值了，但是b还有值，那么就是a<b
        // 1.1.1 1.1.1.1

        // 用于判断后面的是否全为0
        // false 是存在不为0的 true是全为0
        var flag = true
        for (m in j until bLength) {
            if (bList[m].toInt() != 0) {
                flag = false
            }
        }
        return if (flag) {
            0
        } else {
            -1
        }
    } else {
        // (i != aLength && j == bLength) 因为全部等的上面不可能退出while循环

        // 用于判断后面的是否全为0
        // false 是存在不为0的 true是全为0
        var flag = true
        for (m in j until bLength) {
            if (bList[m].toInt() != 0) {
                flag = false
            }
        }
        return if (flag) {
            0
        } else {
            1
        }
    }
}

fun main() {
    println(compare("1.1", "1.01.0"))
}