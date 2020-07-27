package leetcode.easy

/**
 *
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