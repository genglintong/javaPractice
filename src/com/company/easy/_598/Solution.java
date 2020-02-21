package com.company.easy._598;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/range-addition-ii/
 * </p>
 * DATE 2020/2/21.
 *
 * @author genglintong.
 */
public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        for (int[] t : ops) {
            m = Math.min(t[0], m);
            n = Math.min(t[1], n);
        }

        return m * n;
    }

    public static void main(String[] args) {

    }
}
