package com.yanhuan.array;

/**
 * 加一
 *
 * @author YanHuan
 * @date 2021-01-03 21:34
 */
public class LeetCode66 {

    public int[] plusOne(int[] digits) {
        //从最后一位加  所以从最后一位往第一位循环
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + 1;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        //循环结束  进一位 9 99 999 这种情况
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
