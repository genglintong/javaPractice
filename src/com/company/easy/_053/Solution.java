package com.company.easy._053;

/**
 * @author genglintong
 * @package com.company.easy._053
 * @desc https://leetcode-cn.com/problems/maximum-subarray/
 * @date 2019/8/14
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;

        if (len <= 0) return 0;
        int pre = nums[0], max = nums[0];
        for (int i = 1; i < len ; i++) {
            if (pre >= 0) {
                pre += nums[i];
            }else {
                pre = nums[i];
            }

            max = Math.max(max, pre);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
