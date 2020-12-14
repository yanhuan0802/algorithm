package com.yanhuan.sort;

import java.util.Arrays;

/**
 * 归并排序：采用分治法的思想，先分割，再排序，再合并。
 * <p>
 * 归并排序就是一个二叉树后序遍历
 *
 * @author YanHuan
 * @date 2020-12-14 23:29
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        System.out.println("归并排序前：" + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("归并排序后：" + Arrays.toString(arr));
    }

    /**
     * 递归使用归并排序，对arr[l...r]的范围进行排序（前闭区间，后闭区间）
     *
     * @param arr   待排序数组
     * @param left  数组左
     * @param right 数组右
     */
    private static void mergeSort(int[] arr, int left, int right) {
        //对于递归，要处理递归到底的判断，这里就是left>=right。
        if (left >= right) {
            return;
        }
        //分割排序
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        //将左右两部分，利用临时数组进行归并
        merge(arr, left, mid, right);
    }

    /**
     * 将arr[l...mid]和arr[mid+1...r]两部分进行归并
     * <p>
     * i:临时数组左边比较的元素下标；j:临时数组右边比较的元素的下标；k:原数组将要放置的元素下标
     *
     * @param arr   数组
     * @param left  左边值下标
     * @param mid   中间值下标
     * @param right 右边值下标
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        //临时辅助数组
        int[] aux = new int[right - left + 1];
        /*减去的left是原数组相对于临时数组的偏移量*/
        if (right + 1 - left >= 0) {
            System.arraycopy(arr, left, aux, 0, right + 1 - left);
        }

        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            //检查左下标是否越界
            if (i > mid) {
                arr[k] = aux[j - left];
                j++;
                //检查右下标是否越界
            } else if (j > right) {
                arr[k] = aux[i - left];
                i++;
            } else if (aux[i - left] <= aux[j - left]) {
                arr[k] = aux[i - left];
                i++;
            } else {
                arr[k] = aux[j - left];
                j++;
            }
        }
    }
}
