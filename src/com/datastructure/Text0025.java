package com.datastructure;

import com.util.ListNode;

/**
 * 栈
 */
public class Text0025 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode[] stack = new ListNode[k];
        int top = -1;
        ListNode curNode = head;
        head = preHead;
        while (curNode != null) {
            stack[++top] = curNode;
            curNode = curNode.next;
            if (top == k - 1) {
                while (top >= 0) {
                    head.next = stack[top--];
                    head = head.next;
                }
                head.next = curNode;
            }
        }
        return preHead.next;
    }

}
