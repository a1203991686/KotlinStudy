package leetcode.easy

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun minArray(numbers: IntArray): Int {
    var result = numbers[0]
    for (i in numbers.indices) {
        if (numbers[i] >= result) {
            continue
        } else {
            result = numbers[i]
            break
        }
    }
    return result
}
