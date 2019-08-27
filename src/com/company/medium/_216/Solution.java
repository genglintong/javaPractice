package com.company.medium._216;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author genglintong
 * @package com.company.medium._216
 * @desc https://leetcode-cn.com/problems/combination-sum-iii/
 * @date 2019/8/27
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        int[] candidates = new int[]{1,2,3,4,5,6,7,8,9};
        int len = candidates.length;

        if (k > n || n <= 0) {
            return res;
        }
        findCombinationSum3(candidates, 0 , len, k, n, new Stack<>(), res);

        return res;
    }

    private void findCombinationSum3(int[] candidates, int start, int len, int k , int n, Stack<Integer> stack, List<List<Integer>> res)
    {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        if (k == 0 || n == 0) {
            return;
        }

        for (int i = start ; i < len && n >= candidates[i]; i++)
        {
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            stack.add(candidates[i]);
            findCombinationSum3(candidates, i + 1, len, k - 1, n - candidates[i], stack, res);
            stack.pop();
        }
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();

        System.out.println(solution.combinationSum3(3,7));
    }
}
