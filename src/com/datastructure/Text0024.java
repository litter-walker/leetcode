package com.datastructure;

import com.util.ListNode;

/**
 * 遍历： 前后指针
 */
public class Text0024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ans = head.next, curNode = head.next, preNode = head;
        ListNode preDoubleNode = new ListNode();
        preDoubleNode.next = head;
        while (curNode != null) {
            preDoubleNode.next = curNode;
            preNode.next = curNode.next;
            curNode.next = preNode;
            preNode = preNode.next;
            if (preNode != null) {
                preDoubleNode = curNode.next;
                curNode = preNode.next;
            } else {
                break;
            }
        }
        return ans;
    }
}
