package com.datastructure;

public class MyLinkedList {
    static class Node {
        int val;
        Node next;

        Node(int _val) {
            val = _val;
        }
    }

    private final Node head;

    public MyLinkedList() {
        head = new Node(-1);
    }

    public int get(int index) {
        Node curNode = head;
        for (int i = 0; i <= index && curNode != null; i++) {
            curNode = curNode.next;
        }
        if (curNode == null) {
            return -1;
        } else {
            return curNode.val;
        }
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head.next;
        head.next = newNode;
    }

    public void addAtTail(int val) {
        Node preNode = head;
        while (preNode.next != null) {
            preNode = preNode.next;
        }
        preNode.next = new Node(val);
    }

    public void addAtIndex(int index, int val) {
        Node preNode = this.head;
        for (int i = 0; i < index && preNode != null; i++) {
            preNode = preNode.next;
        }
        if (preNode == null) {
            return;
        }
        Node newNode = new Node(val);
        newNode.next = preNode.next;
        preNode.next = newNode;
    }

    public void deleteAtIndex(int index) {
        Node preNode = this.head;
        for (int i = 0; i < index && preNode != null; i++) {
            preNode = preNode.next;
        }
        if (preNode == null || preNode.next == null) {
            return;
        }
        preNode.next = preNode.next.next;
    }
}
