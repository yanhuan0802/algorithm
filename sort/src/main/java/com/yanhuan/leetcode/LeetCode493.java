package com.yanhuan.leetcode;

import java.util.Arrays;

/**
 * 翻转对
 *
 * @author YanHuan
 * @date 2021-03-07 13:59
 */
public class LeetCode493 {
    /**
     * 解法1 mergeSort
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(logn)
     *
     * @param nums 数组
     * @return 翻转对数量
     */
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    /**
     * 归并并返回翻转对数量
     *
     * @param nums 数组
     * @param l    左
     * @param r    右
     * @return 翻转对数量
     */
    private int mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = l + (r - l) / 2;
        //归并
        int count = mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);
        //遍历计算数目
        for (int i = l, j = mid + 1; i <= mid; i++) {
            //翻转对
            while (j <= r && nums[i] / 2.0 > nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
        //排序
        Arrays.sort(nums, l, r + 1);
        return count;
    }
}
