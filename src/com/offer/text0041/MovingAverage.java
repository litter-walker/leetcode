package com.offer.text0041;

/**
 * 自定义队列
 */
public class MovingAverage {

    private Node front;
    private Node rear;
    private final int size;
    private int curSize;
    private double sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        front = new Node(0);
        rear = front;
        this.size = size;
        this.curSize = 0;
        this.sum = 0;
    }

    public double next(int val) {
        if (curSize == size) {
            rear = rear.next;
            curSize--;
            sum -= rear.val;
        }
        front.next = new Node(val);
        curSize++;

        front = front.next;
        sum += val;
        return sum / curSize;
    }

    class Node {
        int val;
        Node next;
        public Node(int _val) {
            val = _val;
        }
    }
}
