package com.company.medium._047;

import java.util.*;

/**
 * @author genglintong
 * @package com.company.medium._047
 * @desc https://leetcode-cn.com/problems/permutations-ii/
 * @date 2019/8/27
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> map = new HashSet<>();
        int len = nums.length;
        boolean[] visited = new boolean[len];

        permuteHelper(nums, visited, 0 , len, map, new Stack<>());
        return new ArrayList<>(map);
    }

    public void permuteHelper(int[] nums, boolean[] visited, int curSize, int len, Set<List<Integer>> res, Stack<Integer> stack)
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
        System.out.println(solution.permuteUnique(new int[]{1,2,1}));
    }
}
