package com.company.easy._453;

import java.util.Arrays;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/
 * </p>
 * DATE 2020/2/11.
 *
 * @author genglintong.
 */
public class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, res = 0;

        for (int i = n-1 ; i > 0 ; i--) {
            res += (n - i) * (nums[i] - nums[i-1]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minMoves(new int[]{1,2,3}));
        System.out.println(solution.minMoves(new int[]{1,1,2147483647}));
    }
}
