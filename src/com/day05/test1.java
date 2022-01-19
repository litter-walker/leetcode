package com.day05;

public class test1 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static  ListNode middleNode(ListNode head) {
        ListNode node1 = head;
        ListNode node2 = head;

        while(node1.next != null) {
            node1 = node1.next;
            node2 = node2.next;

            if(node1.next != null) {
                node1 = node1.next;
            }
        }

        return node2;
    }

    public static void main(String[] args) {

    }

}
