package com.yanhuan.greedy;

/**
 * 跳跃游戏2
 *
 * @author YanHuan
 * @date 2021-01-24 21:42
 */
public class LeetCode45 {
    /**
     * 解法1. 贪心算法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums 数组
     * @return 跳跃次数
     */
    public int jump(int[] nums) {
        if (nums == null) {
            return 0;
        }
        //边界位置
        int end = 0;
        //最大索引位置
        int max = 0;
        //跳跃步数
        int step = 0;
        //因为是起跳的时候就 + 1 了，如果最后一次跳跃刚好到达了最后一个位置，那么遍历到最后一个位置的时候就会再次起跳，这是不允许的，因此不能遍历最后一个位置
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            //遇到边界  更新边界和步数
            if (i == end) {
                end = max;
                step++;
            }
        }
        return step;
    }
}
