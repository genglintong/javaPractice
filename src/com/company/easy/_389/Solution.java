package com.company.easy._389;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/find-the-difference/
 * </p>
 * DATE 2020/2/9.
 *
 * @author genglintong.
 */
public class Solution {
    /**
     * 首先必须遍历一次才可以知道 因此复杂度最小为 O(m + n)
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        if (s == null || s.length() == 0) {
            return t.charAt(0);
        }
        char[] chars_S = s.toCharArray();
        char[] chars_T = t.toCharArray();
        int[] ints = new int[26];

        for (char c : chars_S) {
            ints[c - 'a']++;
        }
        for (char c : chars_T) {
            if (ints[c - 'a']-- == 0) {
                return c;
            }
        }

        return 'a';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheDifference("abcd", "abcde"));
    }
}
