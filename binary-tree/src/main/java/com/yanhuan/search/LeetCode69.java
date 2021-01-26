package com.yanhuan.search;

/**
 * x的平方根
 *
 * @author YanHuan
 * @date 2021-01-26 21:59
 */
public class LeetCode69 {
    /**
     * 解法1： 二分查找
     * 时间复杂度：O(logx)
     * 空间复杂度：O(1)
     *
     * @param x x
     * @return 平方根
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long left = 1, right = x;
        long res = 1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) res;
    }

    /**
     * 解法2： 牛顿迭代
     * 时间复杂度：O(logx)
     * 空间复杂度：O(1)
     *
     * @param x x
     * @return 平方根
     */
    public int mySqrt1(int x) {
        long a = x;
        while (a * a > x) {
            a = (a + x / a) / 2;
        }
        return (int) a;
    }
}
