package com.datastructure;

import com.general.ListNode;

import java.util.Arrays;

/**
 * 递归
 */
public class Text0206 {

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode ansHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return ansHead;
    }

    public static void main(String[] args) {
        int[] head = {1,2,3,4,5};
        System.out.println("head = " + Arrays.toString(head));
        System.out.println("new ListNode(head) = " + new ListNode(head));
        System.out.println("reverseList(new ListNode(head)) = " + reverseList(new ListNode(head)));
    }

}
