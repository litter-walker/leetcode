package com.general.text0622;

/*
    链表模拟队列
 */
public class MyCircularQueue {
    Node front;
    Node rear;

    public MyCircularQueue(int k) {
        if (k < 0) {
            throw new RuntimeException("创建队列空间小于零");
        }
        // 多创建一个节点，便于判断 Empty 和 Full
        Node head = new Node();
        rear = head;
        for (int i = 0; i < k; i++) {
            rear.next = new Node();
            rear = rear.next;
        }
        rear.next = head;
        front = rear;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        rear = rear.next;
        rear.val = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = front.next;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return front.next.val;
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return rear.val;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear.next == front;
    }
}

