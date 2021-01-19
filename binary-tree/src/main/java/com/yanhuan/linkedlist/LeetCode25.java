package com.yanhuan.linkedlist;

import com.yanhuan.ListNode;

/**
 * k个一组翻转链表
 *
 * @author YanHuan
 * @date 2021-01-19 22:43
 */
public class LeetCode25 {
    /**
     * 解法一  递归
     *
     * @param head 链表
     * @param k    分组点
     * @return 翻转结果
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        //找到第k+1个节点
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }
        if (count == k) {
            //处理k+1之后的节点
            curr = reverseKGroup(curr, k);
            //处理当前k个节点
            while (count-- > 0) {
                //已有结果放在当前节点之后  指针右移
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
        }
        return head;
    }
}
