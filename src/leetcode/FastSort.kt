package leetcode

/**
 * 快排
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun fastSort(array: IntArray, left: Int, right: Int) {
    if (array.isEmpty()) {
        return
    }
    if (left > right) {
        return
    }
    var i = left
    var j = right
    val temp = array[left]
    while (i != j) {
        while (array[j] >= temp && i < j && j >= 0) {
            j--
        }
        while (array[i] <= temp && i < j && i >= 0) {
            i++
        }
        if (i < j) {
            val t = array[i]
            array[i] = array[j]
            array[j] = t
        }
    }
    array[left] = array[i]
    array[i] = temp
    fastSort(array, left, i - 1)
    fastSort(array, i + 1, right)
}