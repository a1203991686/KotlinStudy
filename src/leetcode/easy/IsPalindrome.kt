package leetcode.easy

/**
 * 9. 回文数
 * https://leetcode-cn.com/problems/palindrome-number/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun isPalindrome(x: Int): Boolean {
    if (x < 0 || (x % 10 == 0 && x != 0)) {
        return false
    }

    var a = x
    var revertedNumber = 0;
    while (a > revertedNumber) {
        revertedNumber = revertedNumber * 10 + a % 10;
        a /= 10;
    }

    return a == revertedNumber || a == revertedNumber / 10
}
