package com.general.text0558;

/**
 * 递归
 */
@SuppressWarnings("all")
public class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        Node ans = new Node();
        // 如果两个矩阵中，存在一个矩阵是叶子节点，且为 1
        if (quadTree1.isLeaf && quadTree1.val
                || quadTree2.isLeaf && quadTree2.val) {
            ans.isLeaf = true;
            ans.val = true;
            return ans;
        }
        // 如果两个矩阵都是叶子节点，且都为 0
        if (quadTree1.isLeaf && !quadTree1.val
                && quadTree2.isLeaf && !quadTree2.val) {
            ans.isLeaf = true;
            return ans;
        }
        // 剩下不能够一次性解决的情况
        if (quadTree1.isLeaf) {
            // [1, 0], [0, ?]的情况
            ans.topLeft = intersect(quadTree1, quadTree2.topLeft);
            ans.topRight = intersect(quadTree1, quadTree2.topRight);
            ans.bottomLeft = intersect(quadTree1, quadTree2.bottomLeft);
            ans.bottomRight = intersect(quadTree1, quadTree2.bottomRight);
        } else if (quadTree2.isLeaf) {
            // [0, ?], [1, 0] 的情况
            ans.topLeft = intersect(quadTree1.topLeft, quadTree2);
            ans.topRight = intersect(quadTree1.topRight, quadTree2);
            ans.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2);
            ans.bottomRight = intersect(quadTree1.bottomRight, quadTree2);
        } else {
            // [0, ?], [0, ?] 的情况
            ans.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
            ans.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
            ans.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            ans.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        }
        // 当四个节点为叶子节点时，有可能可以收起来
        if (ans.topLeft.isLeaf
                && ans.topRight.isLeaf
                && ans.bottomLeft.isLeaf
                && ans.bottomRight.isLeaf) {
            if (ans.topLeft.val == ans.topRight.val
                    && ans.topLeft.val == ans.bottomLeft.val
                    && ans.topLeft.val == ans.bottomRight.val) {
                ans.val = ans.topLeft.val;
                ans.isLeaf = true;
                ans.topLeft = ans.topRight = ans.bottomLeft = ans.bottomRight = null;
            }
        }
        return ans;
    }
}
