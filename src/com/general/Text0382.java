package com.general;

import java.util.Arrays;
import java.util.Random;

public class Text0382 {

    private ListNode listNode = null;
    private int length = 0;

    public Text0382(ListNode head) {
        this.listNode = head;
        this.length = 0;
        while (listNode != null) {
            this.length++;
            this.listNode = this.listNode.next;
        }
        this.listNode = head;
    }

    public int getRandom() {
        int ans = 0;
        int random = new Random().nextInt(this.length);
        ListNode node = this.listNode;
        while (random-- >= 0 && node != null) {
            ans = node.val;
            node = node.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] valS = {1,2,3,4,5,6,7,8,9,0};
        ListNode listNode = new ListNode(valS);
        System.out.println("listNode = " + listNode);
        Text0382 text0382 = new Text0382(listNode);
        int[] a = {0,0,0,0,0,0,0,0,0,0};
        for (int i = 0; i < 1000000000; i++) {
            a[text0382.getRandom()]++;
        }
        System.out.println("a = " + Arrays.toString(a));

    }
}


