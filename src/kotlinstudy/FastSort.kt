package kotlinstudy

import java.util.*

fun main() {
    val nums: IntArray = intArrayOf(2134, 345, 4, 234, 234, 3, 1, 65, 123, 54, 52)
    val sc = Scanner(System.`in`)
    println("请输入您需要第几小的数")
    val count = sc.nextInt()
    println(qSort(nums, 0, nums.size - 1, count))
}

fun qSort(nums: IntArray, left1: Int, right1: Int, count: Int): Int {
    if (left1 >= right1)
        return -1;
    else {
        val temp = nums[left1]
        var left = left1 + 1
        var right = right1
        while (left < right) {
            while (nums[right] > temp && right > left) {
                right--
            }
            while (nums[left] < temp && left < right) {
                left++
            }
            if (left < right) {
                val swapTemp = nums[left]
                nums[left] = nums[right]
                nums[right] = swapTemp
            }
        }
        if (left == right) {
            val swapTemp = nums[left]
            nums[left] = nums[left1]
            nums[left1] = swapTemp
        }
        for (element in nums) {
            print("$element ")
        }
        println()
        return when {
            left > count -> qSort(nums, left1, left - 1, count)
            left == (count - 1) -> nums[count]
            else -> qSort(nums, left + 1, right1, count)
        }
    }
}