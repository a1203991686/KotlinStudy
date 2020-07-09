package leetcode.easy

/**
 *
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun divingBoard(shorter: Int, longer: Int, k: Int): IntArray {
    if (k == 0) {
        return IntArray(0)
    }

    if (shorter == longer) {
        return IntArray(1) {
            shorter * k
        }
    }
    val lengths = IntArray(k + 1)
    for (i in 0..k) {
        lengths[i] = shorter * (k - i) + longer * i
    }
    return lengths
}