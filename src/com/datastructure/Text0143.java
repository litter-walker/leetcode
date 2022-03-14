package com.datastructure;

import com.util.ListNode;

/**
 * 1、快速解决：线性表 时间O(n),空间O(n)
 * <p>
 * 2、快慢指针寻找中间节点：时间O(n), 空间O(1)
 */
public class Text0143 {
    /*
        // 线性表法
        public void reorderList(ListNode head) {
            List<ListNode> listNodes = new ArrayList<>();
            while (head != null) {
                listNodes.add(head);
                head = head.next;
            }
            int l = 0, r = listNodes.size() - 1;
            if (r == -1) {
                return;
            }
            while (l < r - 1) {
                listNodes.get(l).next = listNodes.get(r);
                listNodes.get(r).next = listNodes.get(l + 1);
                l++;
                r--;
            }
            if (l == r - 1) {
                listNodes.get(l).next = listNodes.get(r);
                listNodes.get(r).next = null;
            } else {
                listNodes.get(l).next = null;
            }
        }
    */

    // 快慢指针
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head1 = reverseList(slow);
        slow.next = null;
        while (head != null && head1 != null) {
            ListNode next = head.next;
            ListNode next1 = head1.next;
            head.next = head1;
            head1.next = next;
            head = next;
            head1 = next1;
        }
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
