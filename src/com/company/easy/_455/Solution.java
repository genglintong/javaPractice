package com.company.easy._455;

import java.util.Arrays;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/assign-cookies/
 * </p>
 * DATE 2020/2/11.
 *
 * @author genglintong.
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int lenS = s.length, lenG = g.length, start = lenG - 1, res = 0;

        for (int i = lenS - 1 ; i >= 0 ; i--) {
            while (start >= 0 && g[start] > s[i]) {
                start--;
            }
            if (start < 0) {
                break;
            }
            res++;
            start--;
        }

        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
    }
}
