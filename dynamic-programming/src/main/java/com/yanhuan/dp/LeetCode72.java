package com.yanhuan.dp;

/**
 * 编辑距离
 *
 * @author YanHuan
 * @date 2021-03-07 17:43
 */
public class LeetCode72 {

    /**
     * 解法1：动态规划
     * 时间复杂度O(mn)
     * 空间复杂度O(mn)
     * <p>
     * 分析： dp[i][j] ： word1.substr(0,i)与word2.substr(0,j)之间的编辑距离
     * 当 w1[i] = w2[j] 时：dp[i][j] = dp[i-1][j-1]
     * 当 w1[i] != w2[j] 时，有三种情况：
     * 1. 最后一个字符替换  dp[i][j] = dp[i-1][j-1] +1;
     * 2. w1删除一个字符  dp[i][j] = dp[i-1][j] +1;
     * 3. w2删除一个字符 dp[i][j] = dp[i][j-1] +1;
     *
     * @param word1 单词1
     * @param word2 单词2
     * @return 最少操作数
     */
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        //初始化
        int[][] dp = new int[n1 + 1][n2 + 1];
        //初始化第一行
        for (int j = 1; j <= n2; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        //初始化第一列
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }
}
