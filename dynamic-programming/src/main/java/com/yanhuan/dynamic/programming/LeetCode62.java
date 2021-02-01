package com.yanhuan.dynamic.programming;

/**
 * 不同路径
 *
 * @author YanHuan
 * @date 2021-02-01 21:58
 */
public class LeetCode62 {

    /**
     * 动态规划：正向遍历
     * <p>
     * 时间复杂度：O(mn)
     * 空间复杂度：O(mn)
     *
     * @param m m
     * @param n n
     * @return 路径数
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //第一行和第一列都是1步
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }


    /**
     * 动态规划：逆向遍历
     * <p>
     * 时间复杂度：O(mn)
     * 空间复杂度：O(mn)
     *
     * @param m m
     * @param n n
     * @return 路径数
     */
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 || j == n - 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
