package com.company.easy._167;

import java.util.Arrays;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * </p>
 * DATE 2020/1/20.
 *
 * @author genglintong.
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0 , end = numbers.length - 1;

        while (start < end) {
            int num = numbers[start] + numbers[end];
            if (num == target) {
                return new int[]{start + 1 , end + 1};
            }else if (num > target) {
                end--;
            }else  {
                start++;
            }
        }
        return new int[]{-1 , -1};
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2,7,11,15};
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.twoSum(numbers, 9)));
    }
}
