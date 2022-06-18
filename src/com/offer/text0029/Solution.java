package com.offer.text0029;

/**
 * 模拟-一次遍历
 */
public class Solution {
    public Node insert(Node head, int insertVal) {
        Node insertNode = new Node(insertVal);
        // head 为 null
        if (head == null) {
            head = insertNode;
            head.next = head;
            return head;
        }
        Node minNode = head, maxNode = head;
        for (Node node = head.next; node != head; node = node.next) {
            if (node.val < minNode.val) {
                minNode = node;
            } else if (node.val >= maxNode.val) {
                maxNode = node;
            }
        }
        // head 只有一个节点时，或者全部节点相同
        if (maxNode.val == minNode.val) {
            insertNode.next = head.next;
            head.next = insertNode;
            return head;
        }
        // head 大于一个节点时, 且节点不同时
        Node preNode = maxNode, curNode = minNode;
        do {
            if (insertVal <= curNode.val || (curNode.val < preNode.val && insertVal > preNode.val)) {
                preNode.next = insertNode;
                insertNode.next = curNode;
                return head;
            }
            preNode = curNode;
            curNode = curNode.next;
        } while (curNode != minNode);
        return null;
    }
}
