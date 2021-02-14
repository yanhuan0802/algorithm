package com.yanhuan.dynamic.programming;

import java.util.List;

/**
 * 三角形最小路径和
 *
 * @author YanHuan
 * @date 2021-02-14 21:31
 */
public class LeetCode120 {

    /**
     * 解法1. 动态规划
     * 时间复杂度： O(n^2)
     * 空间复杂度： O(n)
     *
     * @param triangle 三角形集合
     * @return 最小路径和
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] arr = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                arr[j] = Math.min(arr[j], arr[j + 1]) + triangle.get(i).get(j);
            }
        }
        return arr[0];
    }
}
