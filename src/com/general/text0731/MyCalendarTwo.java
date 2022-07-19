package com.general.text0731;

/**
 * 线段树(动态开点)
 *
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
public class MyCalendarTwo {

    private Node tree;

    public MyCalendarTwo() {
        tree = new Node(0, (int)1e9);
    }

    public boolean book(int start, int end) {
        if (tree.query(start, end - 1) >= 2) {
            return false;
        }
        tree.update(start, end - 1, 1);
        return true;
    }

}