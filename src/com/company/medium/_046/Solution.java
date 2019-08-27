package com.company.medium._046;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author genglintong
 * @package com.company.medium._046
 * @desc https://leetcode-cn.com/problems/permutations/
 * @date 2019/8/27
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        boolean[] visited = new boolean[len];

        permuteHelper(nums, visited, 0 , len, res, new Stack<>());
        return res;
    }

    public void permuteHelper(int[] nums, boolean[] visited, int curSize, int len, List<List<Integer>> res, Stack<Integer> stack)
    {
        if (curSize == len) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0 ; i < len; i++) {
            if (!visited[i]) {
                stack.add(nums[i]);
                visited[i] = true;
                permuteHelper(nums, visited, curSize + 1, len, res, stack);
                visited[i] = false;
                stack.pop();
            }
        }
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.permute(new int[]{1,2,3}));
    }
}
