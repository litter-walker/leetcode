package com.datastructure;

import com.general.ListNode;

/**
 * 遍历：
 */
public class Text0083 {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curNode = head;
        while (curNode.next != null) {
            if (curNode.val == curNode.next.val) {
                curNode.next = curNode.next.next;
            } else {
                curNode = curNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] head = {1,1,2};
        System.out.println("new ListNode(head) = " + new ListNode(head));
        System.out.println("deleteDuplicates(new ListNode(head)) = " + deleteDuplicates(new ListNode(head)));
    }

}
