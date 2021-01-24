package com.yanhuan.greedy;

/**
 * 柠檬水找零
 *
 * @author YanHuan
 * @date 2021-01-24 17:40
 */
public class LeetCode860 {
    /**
     * 解法： 贪心+模拟
     * 时间复杂度 O(n) n为数组长度
     * 空间复杂度 O(1)
     *
     * @param bills 购买顺序
     * @return 是否可以找零
     */
    public boolean lemonadeChange(int[] bills) {
        //最大面额20 所以用五块和十块来找零
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                //面额为20的情况
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five = five - 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
