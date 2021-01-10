package com.yanhuan.linkedlist;

import com.yanhuan.ListNode;

/**
 * 环形链表
 *
 * @author YanHuan
 * @date 2021-01-03 10:56
 */
public class LeetCode141 {

    /**
     * 快慢指针解法
     *
     * @param head 链表
     * @return 是否环形链表
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
