package com.yanhuan.search;

/**
 * 有效的完全平方数
 *
 * @author YanHuan
 * @date 2021-01-26 22:40
 */
public class LeetCode367 {
    /**
     * 解法1 二分法
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     *
     * @param num num
     * @return 是否为完全平方数
     */
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        long left = 2, right = num / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            }
            if (mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    /**
     * 解法2 牛顿迭代
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     *
     * @param num num
     * @return 是否为完全平方数
     */
    public boolean isPerfectSquare1(int num) {
        if (num < 2) {
            return true;
        }
        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return (x * x == num);
    }
}
