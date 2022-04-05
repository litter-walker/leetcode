package com.general;

/**
 * 线段树
 */
public class Text0307 {
}
class NumArray {

    private int[] segmentTree;
    private int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.segmentTree = new int[4 * this.n];
        bulidTree(0, nums, 0, this.n - 1);
    }

    public void update(int index, int val) {
        updateTree(0, index, val, 0, this.n - 1);
    }

    public int sumRange(int left, int right) {
        return sumRange(0, left, right, 0, this.n - 1);
    }

    private void bulidTree(int node, int[] nums, int s, int e) {
        if (s == e) {
            segmentTree[node] = nums[s];
            return;
        }
        int mid = s + (e - s) / 2;
        bulidTree(node * 2 + 1, nums, s, mid);
        bulidTree(node * 2 + 2, nums, mid + 1, e);
        segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
    }

    private void updateTree(int node, int idx, int val, int s, int e) {
        if (idx == s && idx == e) {
            segmentTree[node] = val;
            return;
        }
        int mid = s + (e - s) / 2;
        if (idx <= mid) {
            updateTree(node * 2 + 1, idx, val, s, mid);
        } else {
            updateTree(node * 2 + 2, idx, val, mid + 1, e);
        }
        segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
    }

    private int sumRange(int node, int l, int r, int s, int e) {
        if (l == s && r == e) {
            return segmentTree[node];
        }
        int mid = s + (e - s) / 2;
        if (r <= mid) {
            return sumRange(node * 2 + 1, l, r, s, mid);
        } else if (l > mid) {
            return sumRange(node * 2 + 2, l, r, mid + 1, e);
        } else {
            return sumRange(node * 2 + 1, l, mid, s, mid) + sumRange(node * 2 + 2, mid + 1, r, mid + 1, e);
        }
    }
}