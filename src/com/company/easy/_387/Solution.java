package com.company.easy._387;

import java.util.Stack;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * </p>
 * DATE 2020/2/6.
 *
 * @author genglintong.
 */
public class Solution {
    /**
     * 循环两次
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] ints = new int[26];
        int len = chars.length;

        for (char c : chars) {
            ints[c - 'a']++;
        }
        for (int i = 0; i < len ; i++) {
            if (ints[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("leetcode"));
        System.out.println(solution.firstUniqChar("loveleetcode"));
    }
}
