package com.company.easy._520;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/detect-capital/
 * </p>
 * DATE 2020/2/16.
 *
 * @author genglintong.
 */
public class Solution {
    public boolean detectCapitalUse(String word) {
        int n = 0, len = word.length();
        char[] chars = word.toCharArray();
        boolean isFirst = false;
        for (int i = 0 ; i < len ; i++) {
            if (chars[i] <= 'Z') {
                n++;
                if (i == 0) {
                    isFirst = true;
                }
            }
        }

        return n == 0 || (isFirst && n == 1) || n == word.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.detectCapitalUse("ASSAS"));
        System.out.println(solution.detectCapitalUse("ASaS"));
        System.out.println(solution.detectCapitalUse("asas"));
    }
}
