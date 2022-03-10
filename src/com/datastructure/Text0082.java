package com.datastructure;

import com.util.ListNode;

/**
 * 题目关键点：已排序
 */
public class Text0082 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode curNode = head.next, preNode = head, preOkNode = newHead;
        while (curNode != null) {
            if (preNode.val != curNode.val && preOkNode.next == preNode) { // 保留preNode
                preOkNode = preNode;
            } else if (preNode.val != curNode.val) { // 删除 preOkNode ~ preNode
                preOkNode.next = curNode;
            }
            preNode = preNode.next;
            curNode = curNode.next;
        }
        if (preNode != preOkNode.next) {
            preOkNode.next = null;
        }
        return newHead.next;
    }

}
