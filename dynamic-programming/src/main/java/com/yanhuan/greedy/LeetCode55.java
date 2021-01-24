package com.yanhuan.greedy;

/**
 * 跳跃游戏
 *
 * @author YanHuan
 * @date 2021-01-24 16:20
 */
public class LeetCode55 {
    /**
     * 解法1.
     * 贪心算法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums 数组
     * @return 判断结果
     */
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        //定义可以走到最后一步的索引
        int enableEnd = nums.length - 1;
        //反序遍历
        for (int i = nums.length - 1; i >= 0; i--) {
            // 判断当前点最大值+当前点的索引能否达到  如果可以达到 就把最后一步位置索引前移
            if (nums[i] + i >= enableEnd) {
                enableEnd = i;
            }
        }
        return enableEnd == 0;
    }


    /**
     * 解法2.
     * 贪心算法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums 数组
     * @return 判断结果
     */
    public boolean canJump1(int[] nums) {
        if (nums == null) {
            return false;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果能跳到的最大步数小于i  则证明跳不到点i
            if (i > max) {
                return false;
            }
            //计算能跳到的最大步数
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }
}
