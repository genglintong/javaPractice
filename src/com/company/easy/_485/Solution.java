package com.company.easy._485;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/max-consecutive-ones/
 * </p>
 * DATE 2020/2/14.
 *
 * @author genglintong.
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, len = nums.length, cur = 0;
        for (int num : nums) {
            if (num == 1) {
                cur++;
            } else {
                max = Math.max(max, cur);
                cur = 0;
            }
        }
        return Math.max(max, cur);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }
}
