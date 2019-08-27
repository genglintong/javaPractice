package com.company.medium._337;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author genglintong
 * @package com.company.medium._337
 * @desc https://leetcode-cn.com/problems/combination-sum-iv/
 * @date 2019/8/27
 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        int len = nums.length;
        findCombinationSum4(nums, len, target, new Stack<>(), res);
        return res.size();
    }

    public void findCombinationSum4(int[] nums, int len, int target, Stack<Integer> stack, List<List<Integer>> res)
    {
        if (target == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < len && target >= nums[i] ; i++)
        {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            stack.add(nums[i]);
            findCombinationSum4(nums ,len, target - nums[i], stack, res);
            stack.pop();
        }
    }

    public int combinationSum4Opti(int[] nums, int target) {
        int len = nums.length;

        if (len <= 0 || target <= 0){
            return 0;
        }

        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target ; i++)
        {
            for (int j = 0 ; j < len && nums[j] <= i; j++) {
                dp[i] += dp[i - nums[j]];
            }

            //System.out.println(i + "  " + dp[i]);
        }

        return dp[target];
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();

        System.out.println(solution.combinationSum4Opti(new int[]{3,1,2,4}, 4));
    }
}
