package com.company.medium._016;

import java.util.Arrays;

/**
 * @author genglintong
 * @package com.company.medium._016
 * @desc https://leetcode-cn.com/problems/3sum-closest/
 * @date 2019/8/14
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;

        if (len < 3) return 0;
        int close = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);

        for (int i = 0 ; i < len -2; ) {
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                //System.out.println(sum + " " + i + " " +left+ " " + right+ " ");
                //System.out.println(sum + " " + nums[i] + " " + nums[left] + " " + nums[right]+ " ");
                close = (Math.abs(sum - target) < Math.abs(close - target)) ? sum : close;

                if (sum == target) return target;
                else if (sum > target) right--;
                else left++;
            }
            while (nums[i] == nums[++i] && i < len - 2) ;
        }

        return close;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.threeSumClosest(new int[]{-3,-2,-5,3,-4}, -1));
        //System.out.println(solution.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        //System.out.println(solution.threeSumClosest(new int[]{0,0,0}, 1));
    }
}
