package com.yanhuan.linkedlist;

import com.yanhuan.ListNode;

/**
 * 环形链表2
 *
 * @author YanHuan
 * @date 2021-01-12 23:08
 */
public class LeetCode142 {
    /**
     * 解法1 快慢指针
     *
     *
     * @param head 链表
     * @return 入环链表节点
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            //第一次相等  a为入环前节点数  b为环节点数  f=2nb s=nb
            //慢指针走到入环点使用步数为 k = a+nb;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
