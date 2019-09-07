package com.company.medium._090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/subsets-ii/
 * </p>
 * DATE 2019/9/7.
 *
 * @author genglintong.
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0 ; i < n ; i++) {
            res.add(nums[i]);
        }

        list.add(new ArrayList<>());
        subsetsWithDupHelper(list, new Stack<>(), res, n , 0);
        return list;
    }

    public void subsetsWithDupHelper(List<List<Integer>> list , Stack<Integer> res, List<Integer> num , int k , int pos) {
        for (int i = pos ; i < k ; i++) {
            if (i != pos && num.get(i).equals(num.get(i-1))) {
                continue;
            }
            res.push(num.get(i));
            list.add(new ArrayList<>(res));
            subsetsWithDupHelper(list, res, num, k , i + 1);
            res.pop();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsetsWithDup(new int[] {
                1,2,2
        }));
    }
}
