package com.general.text1206;

class Node {
    int val;
    Node[] next;

    public Node(int _val, int high) {
        val = _val;
        next = new Node[high];
    }
}
