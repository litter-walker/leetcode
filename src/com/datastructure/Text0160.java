package com.datastructure;

import com.util.ListNode;

/**
 * 双指针
 */
public class Text0160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode node1 = headA, node2 = headB;
        while (node1 != node2 ) {
            if (node1 == null) {
                node1 = headB;
            } else {
                node1 = node1.next;
            }
            if (node2 == null) {
                node2 = headA;
            } else {
                node2 = node2.next;
            }
        }
        return node1;
    }

}
