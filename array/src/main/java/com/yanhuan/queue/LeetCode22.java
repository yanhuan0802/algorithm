package com.yanhuan.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *
 * @author YanHuan
 * @date 2021-01-23 10:39
 */
public class LeetCode22 {
    /**
     * 解法1：深度优先、回溯算法
     *
     * @param n 括号组
     * @return 生成结果
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(0, 0, n, "", list);
        return list;
    }

    private void generate(int left, int right, int n, String s, List<String> list) {
        //terminator
        if (left == n && right == n) {
            list.add(s);
            return;
        }
        //process logic in current level
        //drill down
        //判断左括号够了没
        if (left < n) {
            generate(left + 1, right, n, s + "(", list);
        }
        //右括号和左括号数是否一致
        if (left > right) {
            generate(left, right + 1, n, s + ")", list);
        }
    }
}
