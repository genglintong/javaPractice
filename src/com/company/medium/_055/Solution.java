package com.company.medium._055;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/jump-game/
 * </p>
 * DATE 2019/9/3.
 *
 * @author genglintong.
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len<=0) {
            return false;
        }

        int jump = nums[0];

        for (int i = 1; i < len ; i++) {
            if (jump <= 0) {
                return false;
            }
            jump = Math.max(jump - 1, nums[i]);
        }
        return (jump>=0);
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[]{2,3,1,1,4}));
        System.out.println(solution.canJump(new int[]{3,2,1,0,4}));
    }
}
