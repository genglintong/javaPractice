package com.company.easy._532;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/k-diff-pairs-in-an-array/
 * </p>
 * DATE 2020/2/17.
 *
 * @author genglintong.
 */
public class Solution {
    public int findPairs(int[] nums, int k) {
        int len = nums.length, start = 0 , end = 1, diff, res = 0;

        if (k == 0) {
            diff = Integer.MIN_VALUE;
            while (end < len) {
                if (nums[end] == nums[end-1] && nums[end] != diff) {
                    res++;
                }
                diff = nums[end - 1];
                end++;
            }
        }else {
            Arrays.sort(nums);
            while (end < len) {
                diff = nums[end] - nums[start];
                if (diff == k) {
                    res++;
                    start++;
                    end++;
                }else if (diff < k) {
                    end++;
                }else {
                    start++;
                    end++;
                }
            }
        }

        return res;
    }

    public int findPairsOpti(int[] nums, int k) {
        if (k < 0) return 0;
        HashSet<Integer> saw = new HashSet<>(), diff = new HashSet<>();

        for (int i : nums){
            if (saw.contains(i-k)) {
                diff.add(i-k);
            }
            if (saw.contains(i+k)) {
                diff.add(i);
            }
            saw.add(i);
        }

        return diff.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findPairsOpti(new int[]{1,1,1,2,2}, 1));
        System.out.println(solution.findPairsOpti(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(solution.findPairsOpti(new int[]{1,1,1,1,1}, 0));
    }
}
