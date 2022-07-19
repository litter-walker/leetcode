package com.general.text0731;

/**
 * 线段树节点
 */
public class Node {
    int start, end;
    int max, lazy;
    Node left, right;

    public Node(int l, int r) {
        start = l;
        end = r;
    }

    public int query(int l, int r) {
        if (start >= l && end <= r) {
            return max;
        }
        if (r < start || l > end) {
            return 0;
        }
        pushDown();
        return Math.max(left.query(l, r), right.query(l, r));
    }

    public void update(int l, int r, int val) {
        if (r < start || l > end) {
            return;
        }
        if (l <= start && end <= r) {
            max += val;
            lazy += val;
            return;
        }
        pushDown();
        left.update(l, r, val);
        right.update(l, r, val);
        pushUp();
    }

    public void pushDown() {
        int mid = start + (end - start >> 1);
        if (left == null) {
            left = new Node(start, mid);
        }
        if (right == null) {
            right = new Node(mid + 1, end);
        }
        left.max += lazy;
        left.lazy += lazy;
        right.max += lazy;
        right.lazy += lazy;
        lazy = 0;
    }

    public void pushUp() {
        max = Math.max(left.max, right.max);
    }
}
