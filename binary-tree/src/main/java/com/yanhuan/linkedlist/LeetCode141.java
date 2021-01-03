package com.yanhuan.linkedlist;

import com.yanhuan.Node;

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
    public boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node slow = head;
        Node fast = head.next;
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
