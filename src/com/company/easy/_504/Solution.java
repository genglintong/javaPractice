package com.company.easy._504;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/base-7/
 * </p>
 * DATE 2020/2/16.
 *
 * @author genglintong.
 */
public class Solution {
    public String convertToBase7(int num) {
        boolean isPositive = false;
        if (num < 0) {
            isPositive = true;
            num = -num;
        }else if (num == 0) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        while (num > 0) {
            res.insert(0, num % 7);
            num = num / 7;
        }

        if (isPositive) {
            res.insert(0, "-");
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertToBase7(128102));
    }
}
