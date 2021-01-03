package com.yanhuan.array;

import java.util.Stack;

/**
 * 最小栈
 *
 * @author YanHuan
 * @date 2021-01-03 15:18
 */
public class LeetCode155 {
    /**
     * 数据栈+辅助栈
     */
    class MinStack {

        private Stack<Integer> data;

        private Stack<Integer> min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            data = new Stack<>();
            min = new Stack<>();
        }

        public void push(int x) {
            data.push(x);
            if (min.isEmpty() || x <= min.peek()) {
                min.push(x);
            }
        }

        public void pop() {
            int x = data.pop();
            if (x == min.peek()) {
                min.pop();
            }
        }

        public int top() {
            if (!data.isEmpty()) {
                return data.peek();
            }
            throw new RuntimeException("栈中元素为空，操作非法");
        }

        public int getMin() {
            if (!min.isEmpty()) {
                return min.peek();
            }
            throw new RuntimeException("栈中元素为空，操作非法");
        }
    }
}
