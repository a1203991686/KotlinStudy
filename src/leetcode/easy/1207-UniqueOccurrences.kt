package leetcode.easy

/**
 * 1207. 独一无二的出现次数
 * https://leetcode-cn.com/problems/unique-number-of-occurrences/
 * @author littlecorgi
 * @date 2020/10/28
 */
fun uniqueOccurrences(arr: IntArray): Boolean {
    val hashMap = HashMap<Int, Int>()
    for (i in arr) {
        hashMap[i] = hashMap.getOrDefault(i, 0).plus(1)
    }
    val hashSet = HashSet<Int>()
    for (i in hashMap) {
        hashSet.add(i.value)
    }
    return hashMap.size == hashSet.size
}
