package com.general.text1305;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历-归并
 */
public class Text1305 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        innerOrder(root1, list1);
        innerOrder(root2, list2);

        List<Integer> merged = new ArrayList<>();
        int m = list1.size(), n = list2.size();
        int i1 = 0, i2 = 0;
        while (true) {
            if (i1 == m) {
                merged.addAll(list2.subList(i2, n));
                break;
            }
            if (i2 == n) {
                merged.addAll(list1.subList(i1, m));
                break;
            }
            if (list1.get(i1) < list2.get(i2)) {
                merged.add(list1.get(i1));
                i1++;
            } else {
                merged.add(list2.get(i2));
                i2++;
            }
        }
        return merged;
    }

    private void innerOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            innerOrder(root.left, list);
            list.add(root.val);
            innerOrder(root.right, list);

        }
    }
}
