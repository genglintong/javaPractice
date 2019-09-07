package com.company.medium._078;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/subsets/
 * </p>
 * DATE 2019/9/7.
 *
 * @author genglintong.
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0 ; i < n ; i++) {
            res.add(nums[i]);
        }

        subsetsHelper(list, res, n , 0);
        return list;
    }

    public void subsetsHelper(List<List<Integer>> list ,List<Integer> nums, int k , int pos) {
        //System.out.println(nums);
        list.add(new ArrayList<>(nums));
        for (int i = pos ; i < k ; i++) {
            List<Integer> res = new ArrayList<>(nums);
            nums.remove(k - i - 1);
            subsetsHelper(list, nums, k , i + 1);
            nums = res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsets(new int[] {
                1,2,3
        }));
    }
}
