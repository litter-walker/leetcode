package com.algorithm.doublepointer;

import com.util.ListNode;

/**
 * 快慢双指针:
 *  一个指针先走 n 步；另一个指针再开始一起走；
 *  当第一个指针到了最后，第二个指针就是倒数第 n 个
 */
public class Text0019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode slow = new ListNode();
        ListNode newHead = slow;
        slow.next = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }

    public static void main(String[] args) {

    }
}
