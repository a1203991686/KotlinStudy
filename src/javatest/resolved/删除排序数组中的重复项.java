package com.littlecorgi.suanfa.resolved;

/*
public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
        if (nums[j] != nums[i]) {
            i++;
            nums[i] = nums[j];
        }
    }
    return i + 1;
}
 */

public class 删除排序数组中的重复项 {
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[j] == nums[i]) {
                    for (int k = j; k < length - 1; k++) {
                        nums[k] = nums[k + 1];
                    }
                    j = i + 1 - 1;
                    length--;
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }
}
