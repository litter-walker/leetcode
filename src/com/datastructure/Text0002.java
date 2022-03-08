package com.datastructure;

import com.util.ListNode;

/**
 *
 */
public class Text0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode ans = new ListNode();
        ListNode cur = ans;
        while (l1 != null || l2 != null) {
            int sum = cur.val;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.val = sum % 10;
            cur.next = new ListNode(sum / 10);
            if (l1 == null && l2 == null) {
                if (cur.next.val == 0) {
                    cur.next = null;
                }
                return ans;
            }
            cur = cur.next;
        }
        return ans;
    }
}
