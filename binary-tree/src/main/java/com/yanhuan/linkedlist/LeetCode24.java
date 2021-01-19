package com.yanhuan.linkedlist;

import com.yanhuan.ListNode;

/**
 * 两两交换链表中的节点
 *
 * @author YanHuan
 * @date 2021-01-10 19:50
 */
public class LeetCode24 {
    /**
     * 解法1 递归
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param head 链表
     * @return 交换结果
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //临时变量next
        ListNode next = head.next;
        //对next后面的节点递归交换  并将交换结果赋给head.next
        head.next = swapPairs(next.next);
        //将head位置赋给 next.next  即交换了原来 head和head.next的位置
        next.next = head;
        return next;
    }

    /**
     * 解法2 迭代   利用哑节点
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param head 链表
     * @return 交换结果
     */
    public ListNode swapPairs1(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode tmp = dummyHead;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode start = tmp.next;
            ListNode end = tmp.next.next;
            //交换节点
            //前序节点指向第二个节点
            tmp.next = end;
            //第一个节点指向 第二个节点的next节点
            start.next = end.next;
            //第二个节点指向第一个节点
            end.next = start;

            //更换tmp的位置
            tmp = start;
        }
        return dummyHead.next;
    }
}
