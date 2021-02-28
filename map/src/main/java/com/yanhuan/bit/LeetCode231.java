package com.yanhuan.bit;

/**
 * 2的幂
 *
 * @author YanHuan
 * @date 2021-02-28 10:45
 */
public class LeetCode231 {

    /**
     * 解法1 :2的幂  二进制数有且仅有一个1
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     *
     * @param n 整数
     * @return 是否为2的幂
     */
    public boolean isPowerOfTwo(int n) {
        // 大于0  并且  清零最低位的1 后等于0
        return n > 0 && (n & (n - 1)) == 0;
    }
}
