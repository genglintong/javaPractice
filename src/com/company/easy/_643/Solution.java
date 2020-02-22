package com.company.easy._643;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/maximum-average-subarray-i/
 * </p>
 * DATE 2020/2/22.
 *
 * @author genglintong.
 */
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length, t = k - 1;
        double res = 0, cur = 0;

        if (len < k) return 0;

        for (int i = 0 ; i < k ;i++) {
            res += nums[i];
        }
        cur = res;

        for (int i = k; i < len ; i++) {
            cur = cur + nums[i] - nums[i-k];
            if (cur > res) {
                res = cur;
            }
        }

        return res / k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }
}
