package com.datastructure;

import com.util.ListNode;

/**
 * 快慢双指针
 */
public class Text0141 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {

    }

}
