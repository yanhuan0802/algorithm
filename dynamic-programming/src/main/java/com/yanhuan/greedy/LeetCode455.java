package com.yanhuan.greedy;

import java.util.Arrays;

/**
 * 分发饼干
 *
 * @author YanHuan
 * @date 2021-01-24 15:24
 */
public class LeetCode455 {
    /**
     * 贪心算法  排序 然后遍历比较
     * 时间复杂度 O(nlogn+mlogm)：排序+遍历
     * 时间复杂度 O(logn+logm)：排序占用
     *
     * @param g 孩子胃口
     * @param s 饼干
     * @return 满足数
     */
    public int findContentChildren(int[] g, int[] s) {
        //1.排序
        Arrays.sort(g);
        Arrays.sort(s);
        //2.遍历
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            //判断条件
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
