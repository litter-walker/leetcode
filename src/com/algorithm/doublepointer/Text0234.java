package com.algorithm.doublepointer;

import com.util.ListNode;

/**
 * 双指针
 */
public class Text0234 {

    public boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        int[] vals = new int[length];
        cur = head;
        for (int i = 0; i < length; i++) {
            vals[i] = cur.val;
            cur = cur.next;
        }
        int l = 0, r = length - 1;
        while (l < r) {
            if (vals[l] != vals[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
