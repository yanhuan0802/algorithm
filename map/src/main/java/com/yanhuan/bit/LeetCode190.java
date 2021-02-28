package com.yanhuan.bit;

/**
 * 颠倒二进制位
 *
 * @author YanHuan
 * @date 2021-02-28 11:02
 */
public class LeetCode190 {
    /**
     * 解法：位运算颠倒
     *
     * @param n 二进制数
     * @return 颠倒结果
     */
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            //result左移1位
            result <<= 1;
            //如果n最后一位是1  就加到result
            if ((n & 1) == 1) {
                result++;
            }
            //每次算最后一位 所以n右移1位
            n >>= 1;
        }
        return result;
    }
}
