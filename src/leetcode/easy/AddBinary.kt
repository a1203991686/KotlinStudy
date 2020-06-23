package leetcode.easy

/**
 * 67. 二进制求和
 * https://leetcode-cn.com/problems/add-binary/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun addBinary(a: String, b: String): String {
    val num = StringBuilder()
    var i = a.length - 1
    var j = b.length - 1
    var addFlag = false
    while (i >= 0 || j >= 0) {
        if (i >= 0 && j >= 0) {
            val tempSum = a[i].toInt() + b[j].toInt() - '0'.toInt() * 2 + if (addFlag) 1 else 0
            addFlag = if (tempSum >= 2) {
                num.insert(0, tempSum - 2)
                true
            } else {
                num.insert(0, tempSum)
                false
            }
        } else if (i >= 0) {
            val tempSum = a[i].toInt() - '0'.toInt() + if (addFlag) 1 else 0
            addFlag = if (tempSum == 2) {
                num.insert(0, tempSum - 2)
                true
            } else {
                num.insert(0, tempSum)
                false
            }
        } else if (j >= 0) {
            val tempSum = b[j].toInt() - '0'.toInt() + if (addFlag) 1 else 0
            addFlag = if (tempSum == 2) {
                num.insert(0, tempSum - 2)
                true
            } else {
                num.insert(0, tempSum)
                false
            }
        }
        i--
        j--
    }
    if (addFlag) {
        num.insert(0, 1)
    }
    return num.toString()
}