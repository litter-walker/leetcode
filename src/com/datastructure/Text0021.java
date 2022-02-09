package com.datastructure;

import com.util.ListNode;

/**
 * 双指针
 */
public class Text0021 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode();
        ListNode node = head;
        while (true) {
            if (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    node.next = list1;
                    list1 = list1.next;
                } else {
                    node.next = list2;
                    list2 = list2.next;
                }
            } else if (list1 == null) {
                node.next = list2;
                break;
            } else {
                node.next = list1;
                break;
            }
            node = node.next;
        }
        return head.next;
    }

    public static void main(String[] args) {

    }

}
