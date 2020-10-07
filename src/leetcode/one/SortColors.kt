package leetcode.one

/**
 * 75. 颜色分类
 * https://leetcode-cn.com/problems/sort-colors/
 * @author littlecorgi
 * @date 2020/10/7
 */
fun sortColors(nums: IntArray): Unit {
    val n = nums.size
    var ptr = 0
    // 例如数组为2,0,2,1,1,0

    // 把0全部移到最前面来
    for (i in 0 until n) {
        if (nums[i] == 0) {
            val temp = nums[i]
            nums[i] = nums[ptr]
            nums[ptr] = temp
            ++ptr
        }
    }
    // 完成上面操作后，保证了前面全是0
    // 0,0,2,1,1,2

    // 接着在把1全部移动到紧挨着0的最前面来
    for (i in ptr until n) {
        if (nums[i] == 1) {
            val temp = nums[i]
            nums[i] = nums[ptr]
            nums[ptr] = temp
            ++ptr
        }
    }
    // 完成上面操作后，保证了除去0之外的最前面全是1
    // 0,0,1,1,2,2
}
