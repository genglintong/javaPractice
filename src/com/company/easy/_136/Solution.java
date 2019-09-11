package com.company.easy._136;

import java.util.SortedSet;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/single-number/
 * </p>
 * DATE 2019/9/11.
 *
 * @author genglintong.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int t = 0, len = nums.length;
        for (int i = 0 ; i < len ; i++) {
            if (i == 0) {
                t = nums[i];
            }else {
                t ^= nums[i];
            }
        }
        return t;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[]{1,2,3,2,3}));
    }
}
