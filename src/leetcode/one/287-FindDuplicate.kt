package leetcode.one

/**
 * 287. 寻找重复数
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
fun findDuplicate(nums: IntArray): Int {
    var slow = 0
    var fast = 0
    while (true) {
        fast = nums[nums[fast]]
        slow = nums[slow]
        if (slow == fast) {
            fast = 0
            while (nums[slow] != nums[fast]) {
                fast = nums[fast]
                slow = nums[slow]
            }
            return nums[slow]
        }
    }
}
