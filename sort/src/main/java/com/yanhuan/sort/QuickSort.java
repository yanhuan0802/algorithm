package com.yanhuan.sort;

/**
 * 快速排序
 * <p>
 * 快速排序的本质就是把基准数大的都放在基准数的右边,把比基准数小的放在基准数的左边,这样就找到了该数据在数组中的正确位置。
 *
 * 快速排序就是二叉树的前序遍历
 *
 * @author Yan
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = { 49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 找寻基准数据的正确索引
            int index = partition(arr, low, high);
            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];
        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        // 返回tmp的正确位置
        return low;
    }
}
