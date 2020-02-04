package com.company.easy._0242;

import java.util.Arrays;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/valid-anagram/
 * </p>
 * DATE 2020/2/4.
 *
 * @author genglintong.
 */
public class Solution {
    /**
     * 首先先不考虑 字符串是否为空指针 - 可以加上
     *
     * *** 还可以使用hash 更为简单一些 ***
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        /**
         * 1. 均为空指针 返回true
         * 2. 有一个空指针 返回false
         * 3. 字符串相等 返回true
         * 4. 长度不想等 返回false
         */
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }

        char[] char_S = s.toCharArray(), char_T = t.toCharArray();

        Arrays.sort(char_S);
        Arrays.sort(char_T);

        int len = char_S.length;

        for (int i = 0 ; i< len ; i++) {
            if (char_S[i] != char_T[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("rat", "car"));
    }
}
