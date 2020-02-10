package com.company.easy._434;

/**
 * Description
 * <p>
 * </p>
 * DATE 2020/2/10.
 *
 * @author genglintong.
 */
public class Solution {
    public int countSegments(String s) {
        int res = 0;
        if (s == null || s.length() == 0) {
            return res;
        }
        char[] chars = s.toCharArray();
        char pre = ' ';

        for (char c : chars) {
            if (c == ' ' && pre != ' ') {
                res++;
            }
            pre = c;
        }

        if (pre != ' ') {
            res++;
        }

        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSegments("Hello, my name is John"));
    }
}
