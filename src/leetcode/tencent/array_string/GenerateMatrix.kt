package leetcode.tencent.array_string

/**
 * 螺旋矩阵 II
 * https://leetcode-cn.com/leetbook/read/tencent/x5rn92/
 * @author littlecorgi
 * @date 2020/10/9
 */
fun generateMatrix(n: Int): Array<IntArray> {
    var index = 1
    val array = Array(n) {
        IntArray(n)
    }
    var left = 0
    var right = n - 1
    var top = 0
    var bottom = n - 1
    while (left <= right && top <= bottom) {
        for (i in left..right) {
            array[top][i] = index++
        }
        for (i in top + 1..bottom) {
            array[i][right] = index++
        }
        if (left < right && top < bottom) {
            for (i in right - 1 downTo left) {
                array[bottom][i] = index++
            }
            for (i in bottom - 1 downTo top + 1) {
                array[i][left] = index++
            }
        }
        left++
        right--
        top++
        bottom--
    }
    return array
}
