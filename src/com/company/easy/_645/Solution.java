package com.company.easy._645;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/set-mismatch/
 * </p>
 * DATE 2020/2/23.
 *
 * @author genglintong.
 */
public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] judge = new int[nums.length];
        long num = 0, repeat = 0;

        for (int n : nums) {
            if (judge[n-1]++ > 0) {
                repeat = n;
            }
            num += n;
        }

        return new int[]{(int) repeat, (int) (((1 + nums.length)*nums.length/2) + repeat - num)};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findErrorNums(new int[]{1,2,2,4})));
    }
}
