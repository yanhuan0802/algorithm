package com.yanhuan.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 剑指offer 40 题
 * 最小的K个数
 *
 * @author YanHuan
 * @date 2021-01-06 22:51
 */
public class Offer40 {
    /**
     * 解法1 sort
     * 时间复杂度O(nlogN)
     * 空间复杂度O(logN)
     *
     * @param arr 数组
     * @param k   k
     * @return 结果
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k < 0) {
            return null;
        }
        Arrays.sort(arr);
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    /**
     * 解法2 堆
     * 时间复杂度O(nlogK)
     *
     * @param arr 数组
     * @param k   k
     * @return 结果
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int j : arr) {
            heap.add(j);
        }
        int[] ints = new int[k];
        for (int i = 0; i < k; i++) {
            Integer poll = heap.poll();
            if (poll != null) {
                ints[i] = poll;
            }
        }
        return ints;
    }
}
