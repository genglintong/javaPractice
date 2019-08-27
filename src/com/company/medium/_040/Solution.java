package com.company.medium._040;

import java.util.*;

/**
 * @author genglintong
 * @package com.company.medium._040
 * @desc https://leetcode-cn.com/problems/combination-sum-ii/
 * @date 2019/8/27
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Arrays.sort(candidates);
        findCombinationSum2(candidates, 0 , len, target, new Stack<>(), res);
        return res;
    }

    private void findCombinationSum2(int[] candidates, int start, int len, int residue, Stack<Integer> stack, List<List<Integer>> res)
    {
        if (residue == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = start ; i < len && residue >= candidates[i]; i++) {
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            stack.add(candidates[i]);
            findCombinationSum2(candidates, i + 1, len, residue - candidates[i], stack, res);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
