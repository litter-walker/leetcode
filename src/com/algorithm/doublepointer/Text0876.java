package com.algorithm.doublepointer;

import com.util.ListNode;

/**
 * 快慢双指针
 */
public class Text0876 {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static void main(String[] args) {

    }
}
