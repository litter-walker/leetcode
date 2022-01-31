package com.datastructure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 使用Set保存, 查看最后长度是否小于原来长度;
 */
public class Text0217 {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("containsDuplicate(nums) = " + containsDuplicate(nums));
    }
}
