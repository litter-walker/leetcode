package com.general.text0641;

/*
    链表
 */
public class MyCircularDeque {

    private Node rear;
    private Node front;
    private int k, cutNode;

    public MyCircularDeque(int k) {
        front = rear = new Node();
        this.k = k;
        this.cutNode = 0;
    }

    public boolean insertFront(int value) {
        if (cutNode >= k) {
            return false;
        }

        front.next = new Node();
        front.next.pre = front;
        front = front.next;
        front.val = value;
        cutNode++;
        return true;
    }

    public boolean insertLast(int value) {
        if (cutNode >= k) {
            return false;
        }

        rear.val = value;
        rear.pre = new Node();
        rear.pre.next = rear;
        rear = rear.pre;
        cutNode++;
        return true;
    }

    public boolean deleteFront() {
        if (cutNode <= 0) {
            return false;
        }
        front = front.pre;
        front.next = null;
        cutNode--;
        return true;
    }

    public boolean deleteLast() {
        if (cutNode <= 0) {
            return false;
        }
        rear = rear.next;
        rear.pre = null;
        cutNode--;
        return true;
    }

    public int getFront() {
        if (cutNode <= 0) {
            return -1;
        }
        return front.val;
    }

    public int getRear() {
        if (cutNode <= 0) {
            return -1;
        }
        return rear.next.val;
    }

    public boolean isEmpty() {
        return cutNode <= 0;
    }

    public boolean isFull() {
        return cutNode >= k;
    }
}
