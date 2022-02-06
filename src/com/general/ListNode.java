package com.general;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] valS) {
        ListNode listNode = this;
        for (int i = 0; i < valS.length; i++) {
            listNode.val = valS[i];
            if (i != valS.length - 1) {
                listNode.next = new ListNode();
                listNode = listNode.next;
            }
        }
    }

    @Override
    public String toString() {
        if (this.next != null) {
            return this.next.toString() + this.val;
        }
        return this.val + "";
    }
}
