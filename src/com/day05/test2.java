package com.day05;

public class test2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode node1 = head;
        for (int i = 0; i < n; i++) {
            node1 = node1.next;
        }
        if (node1 == null) {
            return head.next;
        }

        ListNode node2 = head;
        while (node1.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        if (node2.next != null) {
            node2.next = node2.next.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
