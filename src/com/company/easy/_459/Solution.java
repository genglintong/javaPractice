package com.company.easy._459;

import java.util.SortedSet;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/repeated-substring-pattern/
 * </p>
 * DATE 2020/2/11.
 *
 * @author genglintong.
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.repeatedSubstringPattern("abcabc"));
    }
}
