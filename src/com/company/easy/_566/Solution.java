package com.company.easy._566;

import java.util.Arrays;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/reshape-the-matrix/
 * </p>
 * DATE 2020/2/20.
 *
 * @author genglintong.
 */
public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int l, n, all;
        l = nums.length;

        if (l == 0) return nums;
        n = nums[0].length;
        all = l * n;
        if (l * n != r * c) return nums;

        int[][] reNums = new int[r][c];

        for (int i = 0 ; i < all ; i++) {
            reNums[i/c][i%c] = nums[i/n][i%n];
        }

        return reNums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] res = solution.matrixReshape(new int[][]{{1,2},{3,4}}, 1,4);

        for (int[] a : res) {
            System.out.println(Arrays.toString(a));
        }
    }
}
