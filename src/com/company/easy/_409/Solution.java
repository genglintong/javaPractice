package com.company.easy._409;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/longest-palindrome/
 * </p>
 * DATE 2020/2/9.
 *
 * @author genglintong.
 */
public class Solution {
    public int longestPalindrome(String s) {
        int[] ints = new int[100];
        int res = 0;
        boolean isOne = false;
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c >= 'a') {
                ints[c - 'a'] ++;
            }else {
                ints[c - 'A' + 30] ++;
            }
        }
        for (int i : ints) {
            if (i >= 2) {
                res += i / 2 * 2;
            }
            if (!isOne && i % 2 == 1) {
                isOne = true;
            }
        }

        return res + (isOne ? 1 : 0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("AAAA"));
    }
}
