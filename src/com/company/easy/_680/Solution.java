package com.company.easy._680;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/valid-palindrome-ii/
 * </p>
 * DATE 2020/2/24.
 *
 * @author genglintong.
 */
public class Solution {
    char[] chars;
    public boolean validPalindrome(String s) {
        chars = s.toCharArray();
        int start = 0 , end = s.length()-1;

        while (start <= end) {
            if (chars[start] != chars[end]) {
                return isPalindrome(start+1, end) | isPalindrome(start, end-1);
            }

            start++;
            end--;
        }

        return true;
    }

    public boolean isPalindrome(int s, int e) {
        while (s <= e) {
            if (chars[s++] != chars[e--]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validPalindrome("ababa"));
        System.out.println(solution.validPalindrome("abca"));
    }
}
