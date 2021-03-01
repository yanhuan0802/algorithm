package com.yanhuan.sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author YanHuan
 * @date 2021-03-01 23:44
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        System.out.println("堆排序前：" + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("堆排序后：" + Arrays.toString(arr));
    }

    public static void heapSort(int[] array) {
        if (array.length == 0) {
            return;
        }
        //通过数组实现一个二叉堆
        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        //遍历数组  依次取出堆顶元素，放到最前面
        for (int i = length - 1; i >= 0; i--) {
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;
            heapify(array, i, 0);
        }
    }

    /**
     * 构建二叉堆
     *
     * @param array  数组
     * @param length 长度
     * @param i      当前索引
     */
    private static void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;

        if (left < length && array[left] > array[largest]) {
            largest = left;
        }

        if (right < length && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int tmp = array[i];
            array[i] = array[largest];
            array[largest] = tmp;
            heapify(array, length, largest);
        }
    }
}
