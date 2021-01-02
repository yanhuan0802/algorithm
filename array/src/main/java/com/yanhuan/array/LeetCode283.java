package com.yanhuan.array;

/**
 * 移动0
 *
 * @author YanHuan
 * @date 2021-01-02 16:22
 */
public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        //j 记录下一个非零变量的位置
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    //交换的作用
                    nums[i] = 0;
                }
                j++;
            }
        }

    }
}
