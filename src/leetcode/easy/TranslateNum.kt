package leetcode.easy

/**
 * 面试题46. 把数字翻译成字符串
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 *
 * 可以用滚动数组进行优化！！！！
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun translateNum(num: Int): Int {
    val str = "$num"

    if (str.isEmpty()) {
        return 0
    } else if (str.length == 1) {
        return 1
    }

    val dps = IntArray(str.length)
    dps[str.length - 1] = 1
    if (str[str.length - 2] > '2' || str[str.length - 2] == '0') {
        dps[str.length - 2] = 1
    } else if (str[str.length - 2] == '2' && str[str.length - 1] >= '6') {
        dps[str.length - 2] = 1
    } else if (str[str.length - 2] == '2' && str[str.length - 1] < '6') {
        dps[str.length - 2] = 2
    } else if (str[str.length - 2] == '1') {
        dps[str.length - 2] = 2
    }
    for (i in str.length - 3 downTo 0) {
        if (str[i] > '2' || str[i] == '0') {
            dps[i] = dps[i + 1]
        } else if (str[i] == '2' && str[i + 1] >= '6') {
            dps[i] = dps[i + 1]
        } else if (str[i] == '2' && str[i + 1] < '6') {
            dps[i] = dps[i + 1] + dps[i + 2]
        } else if (str[i] == '1') {
            dps[i] = dps[i + 1] + dps[i + 2]
        }
    }
    return dps[0]
}