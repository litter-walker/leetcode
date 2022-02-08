package com.datastructure;

/**
 * 直接使用API
 */
public class Text0232 {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        System.out.println("myQueue.toString() = " + myQueue.toString());
        myQueue.push(1); // queue is: [1]
        System.out.println("myQueue.toString() = " + myQueue.toString());
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println("myQueue.toString() = " + myQueue.toString());
        myQueue.peek(); // return 1
        System.out.println("myQueue.toString() = " + myQueue.toString());
        myQueue.pop(); // return 1, queue is [2]
        System.out.println("myQueue.toString() = " + myQueue.toString());
        myQueue.empty(); // return false
        System.out.println("myQueue.toString() = " + myQueue.toString());
    }
}

