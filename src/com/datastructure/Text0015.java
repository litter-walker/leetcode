package com.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 双指针
 */
public class Text0015 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int third = nums.length - 1;
                while (third > second && nums[first] + nums[second] + nums[third] > 0) {
                    third--;
                }
                if (second != third && nums[first] + nums[second] + nums[third] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ansList.add(list);
                }
            }
        }
        return ansList;
    }

}
