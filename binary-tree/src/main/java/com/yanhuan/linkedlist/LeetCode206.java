package com.yanhuan.linkedlist;

import com.yanhuan.ListNode;

/**
 * 翻转链表
 *
 * @author YanHuan
 * @date 2021-01-09 16:20
 */
public class LeetCode206 {
    /**
     * 解法1  迭代
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param head 链表
     * @return 翻转结果
     */
    public ListNode reverseList(ListNode head) {
        //初始化返回值
        ListNode res = null;
        while (head != null) {
            //已有结果放在当前节点之后 指针右移
            ListNode tmp = head.next;
            head.next = res;
            res = head;
            head = tmp;
        }
        return res;
    }

    /**
     * 解法2  递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param head 链表
     * @return 翻转结果
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //递归翻转next节点
        ListNode pre = reverseList1(head.next);
        //当前的结果应该是 1 -> 2 <- 3 <- 4 <-5  将2指向1  1指向null
        head.next.next = head;
        head.next = null;
        return pre;
    }
}
