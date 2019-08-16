package com.company.easy._066;

import com.company.util.Util;

import java.util.Arrays;

/**
 * @author genglintong
 * @package com.company.easy._066
 * @desc https://leetcode-cn.com/problems/plus-one/
 * @date 2019/8/16
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int target = 0;

        digits[len - 1]++;

        if (digits[len - 1] < 10) return digits;

        for (int i = len - 1 ; i >= 0 ; i--) {
            digits[i] += target;
            if (digits[i] >= 10) {
                digits[i] -= 10;
                target = 1;
            }else {
                return digits;
            }
        }

        int[] newD = new int[len+1];
        newD[0] = 1;
        for (int i = 1; i <= len ; i++) {
            newD[i] = digits[i-1];
        }

        return newD;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9,9,9})));
    }
}
