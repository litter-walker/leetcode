package com.datastructure;

import com.util.ListNode;

import java.util.HashSet;

/**
 * 哈希表
 */
public class Text0142 {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
