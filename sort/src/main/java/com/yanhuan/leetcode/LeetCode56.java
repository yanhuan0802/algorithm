package com.yanhuan.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 合并区间
 *
 * @author YanHuan
 * @date 2021-03-07 11:24
 */
public class LeetCode56 {

    /**
     * 解法1 排序+一次扫描
     * 时间复杂度：O(nlogn),排序占用
     * 空间复杂度：O(logn)，排序占用
     *
     * @param intervals 二维数组
     * @return 合并结果
     */
    public int[][] merge(int[][] intervals) {
        //特判
        if (intervals.length == 0) {
            return new int[0][2];
        }
        //排序  按照首位排序
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        //遍历扫描
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            //如果当前结果数组是空的或者 结果的最后一位小于当前数组的起始位置 则不合并，直接加到数组后面
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                //合并
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        //copy  返回
        return Arrays.copyOf(res, idx + 1);
    }
}
