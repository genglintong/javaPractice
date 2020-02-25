package com.company.easy._696;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/count-binary-substrings/
 * </p>
 * DATE 2020/2/25.
 *
 * @author genglintong.
 */
public class Solution {
    public int countBinarySubstrings(String s) {
        int pre = 0, cur = 1, res = 0, len = s.length();
        char[] chars = s.toCharArray();

        for (int i = 1; i < len ; i++) {
            if (chars[i] == chars[i-1]) {
                cur++;
                if (cur <= pre) res++;
            }else {
                pre = cur;
                cur = 0;
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countBinarySubstrings("00110011"));
    }
}
