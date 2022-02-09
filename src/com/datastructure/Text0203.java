package com.datastructure;

import com.util.ListNode;

/**
 * 遍历：
 *  使用新的头的next指向整个链表
 */
public class Text0203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode();
        ListNode cur = newHead;
        newHead.next = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {

    }
}
