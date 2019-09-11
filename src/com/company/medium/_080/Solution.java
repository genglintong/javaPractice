package com.company.medium._080;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * </p>
 * DATE 2019/9/9.
 *
 * @author genglintong.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int newLen = 0;
        int pre0 = 0;
        int pre1 = 0;
        for (int i = 0 ; i < len ; i++) {
            if (i < 2 || nums[i] != pre0 || nums[i] != pre1) {
                nums[newLen++] = nums[i];
            }
            pre1 = pre0;
            pre0 = nums[i];
        }
        return newLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }
}
