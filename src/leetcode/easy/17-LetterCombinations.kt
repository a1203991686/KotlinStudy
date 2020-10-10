package leetcode.easy

/**
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
private fun letterCombinations(digits: String): List<String> {
    val result = ArrayList<String>()
    if (digits.isEmpty()) {
        return result
    }
    val phoneMap = hashMapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )
    backtrack(result, phoneMap, digits, 0, StringBuilder())
    return result
}

/**
 * 这个方法太强了。。。
 * 具体见leetcode题解（非官方）
 * 类似于树，以 "23" 举例
 * index=0时，就对应的是2，那么就取出2对应的所有的字符，然后挨个遍历，并且对于每一次遍历，添加到combination中去，
 *  然后开始递归，index+1，此时也就对应的是3，那么取出3对应的所有字符，然后再挨个遍历，并且对于每一次遍历，添加到combination中，然后再递归
 *  此次递归就发现index和length相等了，也就到了递归的头，就把当前的combination添加进去。然后回退，将此次递归的删除掉，然后继续去遍历
 *
 *                    2
 *        /           |           \
 *        a           b           c
 *        ↓           ↓           ↓
 *        3           3           3
 *    /   |   \    /  |   \    /  |   \
 *    d   e   f   d   e   f   d   e   f
 *    ↓   ↓   ↓   ↓   ↓   ↓   ↓   ↓   ↓
 *    ad  ad  af  bd  be  bf  cd  ce  cf
 */
private fun backtrack(
    combinations: ArrayList<String>,
    phoneMap: Map<Char, String>,
    digits: String,
    index: Int,
    combination: StringBuilder
) {
    if (index == digits.length) {
        combinations.add(combination.toString())
    } else {
        val digit = digits[index]
        val letters = phoneMap[digit]
        letters?.run {
            val lettersCount = length
            for (i in 0 until lettersCount) {
                combination.append(letters[i])
                backtrack(combinations, phoneMap, digits, index + 1, combination)
                combination.deleteCharAt(index)
            }
        }
    }
}
