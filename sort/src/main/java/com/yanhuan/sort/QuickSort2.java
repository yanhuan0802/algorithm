package com.yanhuan.sort;

/**
 * 快速排序  另一种找基准值的方法
 *
 * @author YanHuan
 * @date 2021-03-01 22:42
 */
public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void quickSort(int[] arr, int begin, int end) {
        if (end <= begin) {
            return;
        }
        //排序 找基准值
        int pivot = partition(arr, begin, end);

        //子数列用相同的方法进行排序
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int begin, int end) {
        //标杆位置
        int pivot = end;
        //小于pivot的元素的个数
        int count = begin;
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                //当前元素小于基准值  将当前这个比较小的数换到目前count的位置
                int tmp = arr[count];
                arr[count] = arr[i];
                arr[i] = tmp;
                //比基准值小
                count++;
            }
        }
        //没有比基准值小的了，将基准值换到count的位置
        int tmp = arr[pivot];
        arr[pivot] = arr[count];
        arr[count] = tmp;
        return count;
    }
}
