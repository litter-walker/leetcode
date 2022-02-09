package com.general;

import com.util.ListNode;

public class Text0002 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        while (l1 != null || l2 != null) {
            int sum = cur.val;
            if (l1 != null) {
                sum +=  l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.val = sum % 10;
            cur.next = new ListNode(sum / 10);
            if(l1 == null && l2 == null) {
                if(cur.next.val == 0) {
                    cur.next = null;
                }
                break;
            }
            cur = cur.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = new ListNode(new int[]{9, 9, 9, 9});
        System.out.println("l1 = " + l1);
        System.out.println("l2 = " + l2);
        System.out.println("addTwoNumbers(l1, l2) = " + addTwoNumbers(l1, l2));


    }


}
