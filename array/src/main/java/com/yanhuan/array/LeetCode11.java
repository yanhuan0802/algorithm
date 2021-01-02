package com.yanhuan.array;

/**
 * 盛最多水的容器
 *
 * @author YanHuan
 * @date 2021-01-02 16:59
 */
public class LeetCode11 {

    public int maxArea(int[] height) {
        if (height == null) {
            return 0;
        }
        int i = 0, j = height.length - 1, max = 0;
        while (i < j) {
            //短边*宽度-->从短边收敛
            /**
             * 只从短边收敛的原理：
             *     一开始就已经把指针定义在两端，如果短指针不动，而把长指针向着另一端移动，两者的距离已经变小了，无论会不会遇到更高的指针，结果都只是以短的指针来进行计算,
             *  即宽度变小，高度不会增加，故移动长指针是无意义的。
             */
            max = height[i] < height[j] ?
                    Math.max(max, (j - i) * height[i++]) :
                    Math.max(max, (j - i) * height[j--]);
        }
        return max;
    }
}
