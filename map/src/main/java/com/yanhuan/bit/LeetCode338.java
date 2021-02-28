package com.yanhuan.bit;

/**
 * 比特位计数
 *
 * @author YanHuan
 * @date 2021-02-28 11:25
 */
public class LeetCode338 {

    /**
     * 解法1：动态规划  最低有效位
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param num 非负整数
     * @return 1的数目
     */
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            //i右移一位与当前值只有一位不同   就用右移一位加上 当前最后一位是否为1
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}
