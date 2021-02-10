package com.yanhuan.search;

/**
 * Pow(x,n)
 *
 * @author YanHuan
 * @date 2021-02-10 9:36
 */
public class LeetCode50 {

    /**
     * 解法1： 分治法
     * 时间复杂度：O(logN)
     * 空间复杂度：O(logN)
     *
     * @param x x
     * @param n n
     * @return Pow(x, n)
     */
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
