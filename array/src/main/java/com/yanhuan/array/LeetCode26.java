package com.yanhuan.array;

/**
 * 删除排序数组中的重复项
 *
 * @author YanHuan
 * @date 2021-01-03 22:14
 */
public class LeetCode26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //快慢指针  slow 为慢指针  j为快指针  0-i就是只出现一次的元素
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            //快慢指针相同时快指针向后移动一位，不相同时将快指针的值赋给慢指针的下一位
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        //返回位数  index+1
        return slow + 1;
    }
}
