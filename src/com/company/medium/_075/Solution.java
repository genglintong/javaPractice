package com.company.medium._075;

import com.company.util.Util;

import java.util.Arrays;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/sort-colors/
 * </p>
 * DATE 2019/9/6.
 *
 * @author genglintong.
 */
public class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int s = 0, e = n - 1;

        while (s <= e) {
            while (nums[s] == 0) {
                s++;
            };
            while (nums[e--] != 0) {
                e--;
            };
            System.out.println(e + " " + s);
            Util.swap(nums, e, s);
        }

        System.out.println(Arrays.toString(nums));

        e = n - 1;
        while (s <= e) {
            while (nums[s++] != 1);
            while (nums[e--] == 1);
            Util.swap(nums, e, s);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0,2,1,0,2,1,0};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
