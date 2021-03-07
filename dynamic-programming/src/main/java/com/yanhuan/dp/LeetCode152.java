package com.yanhuan.dp;

/**
 * 乘积的最大子数组
 *
 * @author YanHuan
 * @date 2021-02-14 22:34
 */
public class LeetCode152 {

    /**
     * 解法1：动态规划
     * 考虑当前值为负数的情况，最大值和最小值交换  再进行计算
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums 数组
     * @return 最大乘积
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1, imin = 1;
        for (int num : nums) {
            if (num < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }

            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);

            max = Math.max(max, imax);
        }
        return max;
    }
}
