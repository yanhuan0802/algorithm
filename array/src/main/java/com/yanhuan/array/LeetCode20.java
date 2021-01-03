package com.yanhuan.array;

import java.util.Stack;

/**
 * 有效的括号
 *
 * @author YanHuan
 * @date 2021-01-03 14:11
 */
public class LeetCode20 {

    /**
     * 特判：
     * 1.过滤空字符串
     * 2.创建一个辅助栈：
     * 3.遍历，对每一个字符进行如下操作：
     * a.若为左括号，则往栈中存放右括号
     * b.若为右括号，如果 栈为空 或者 该右括号与取出的栈顶元素不一样，则返回false;
     * 4.返回栈是否为空的状态；
     *
     * @param s 字符串
     * @return 是否有效
     */
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
