package com.company.medium._073;

import java.util.Arrays;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/set-matrix-zeroes/
 * </p>
 * DATE 2019/9/5.
 *
 * @author genglintong.
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m <= 0 ) {
            return;
        }
        int n = matrix[0].length;
        if (n <= 0 ) {
            return;
        }

        boolean[] judgeM = new boolean[m];
        boolean[] judgeN = new boolean[n];

        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (matrix[i][j] == 0) {
                    judgeM[i] = true;
                    judgeN[j] = true;
                }
            }
        }

        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (judgeM[i] == true || judgeN[j] == true) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][] {
                {},
                {},
                {}
        };

        for (int i = 0 ;i < matrix.length ; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

}
