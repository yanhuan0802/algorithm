package com.yanhuan.bit;

/**
 * 位1 的个数
 *
 * @author YanHuan
 * @date 2021-02-28 10:27
 */
public class LeetCode191 {

    /**
     * 解法1. 清零最低位的1
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     *
     * @param n 二进制串
     * @return 位1 的个数
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            //在二进制表示中，数字n中最低位的1总是对应n-1中的0，
            //所以与运算总是能把n中的最低位的1变成0，并保持其他位不变。
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    /**
     * 解法2. 计算每一位是否为1  右移
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     *
     * @param n 二进制串
     * @return 位1 的个数
     */
    public int hammingWeight1(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}
