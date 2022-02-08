package com.datastructure;

import java.util.Deque;
import java.util.LinkedList;

@SuppressWarnings("ConstantConditions")
public class MyQueue {

    private final Deque<Integer> queue;

    public MyQueue() {
        this.queue = new LinkedList<>();
    }

    public void push(int x) {
        this.queue.push(x);
    }

    public int pop() {
        return this.queue.pollLast();
    }

    public int peek() {
        return this.queue.peekLast();
    }

    public boolean empty() {
        return this.queue.isEmpty();
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "queue=" + this.queue +
                '}';
    }
}
