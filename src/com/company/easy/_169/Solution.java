package com.company.easy._169;

/**
 * Description
 * <p>
 * </p>
 * DATE 2019/11/28.
 *
 * @author genglintong.
 */
public class Solution {
    /**
     * 使用摩尔投票法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int target = 0, targetNum = 0;

        for (int n : nums) {
            if (n == target) {
                targetNum++;
            }else {
                targetNum--;
            }

            if (targetNum < 0) {
                targetNum = 0;
                target = n;
            }
        }

        return target;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,212,12};
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(nums));
    }
}
