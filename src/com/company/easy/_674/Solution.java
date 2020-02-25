package com.company.easy._674;

import java.util.ArrayList;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 * </p>
 * DATE 2020/2/24.
 *
 * @author genglintong.
 */
public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int cur = 1, max = cur, len = nums.length;

        if (len < 1) return 0;

        for (int i = 1; i < len ; i++) {
            if (nums[i] > nums[i-1]) {
                cur++;
            }else {
                max = Math.max(max, cur);
                cur = 1;
            }
        }

        return Math.max(max, cur);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLengthOfLCIS(new int[]{1,3,5,4,7}));
        System.out.println(solution.findLengthOfLCIS(new int[]{2,2,2,2,2,2}));
    }
}
