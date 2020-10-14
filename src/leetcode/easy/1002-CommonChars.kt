package leetcode.easy

/**
 * 1002. 查找常用字符
 * https://leetcode-cn.com/problems/find-common-characters/
 * @author littlecorgi
 * @date 2020/10/14
 */
fun commonChars(A: Array<String>): List<String> {
    val array = IntArray(26) { Int.MAX_VALUE }
    for (a in A) {
        val minArray = IntArray(26) { 0 }
        for (i in a) {
            minArray[i - 'a']++
        }
        for (i in 0..25) {
            array[i] = Math.min(array[i], minArray[i])
        }
    }
    val result = ArrayList<String>()
    for (i in 0..25) {
        if (array[i] != 0) {
            repeat(array[i]) {
                result.add('a'.plus(i).toString())
            }
        }
    }
    return result
}
