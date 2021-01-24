package com.yanhuan.search;

/**
 * 二分查找代码模板
 *
 * @author YanHuan
 * @date 2021-01-24 22:46
 */
public class BinarySearch {
    public int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1, mid;
        while (left <= right) {
            //求中间位置索引
            // 这里为什么不用(left+right)/2:当left、right两个数足够大时，相加会越界，所以使用下面的表达式防止越界
            // 进一步演化可以使用位运算 (left+(right-left)>>1) 因为计算机语言处理位运算更快
            mid = (right - left) / 2 + left;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
