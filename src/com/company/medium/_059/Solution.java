package com.company.medium._059;

import java.util.Arrays;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/spiral-matrix-ii/
 * </p>
 * DATE 2019/9/3.
 *
 * @author genglintong.
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return null;
        }

        int[][] matrix = new int[n][n];
        boolean[][] seed = new boolean[n][n];
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};
        int r = 0 , c = 0 , di = 0;
        int num = n * n;

        for (int i = 0 ; i < num ; i++) {
            matrix[r][c] = i + 1;
            seed[r][c] = true;

            int cr = r + dr[di], cc = c + dc[di];
            if (cr >= 0 && cr < n && cc >= 0 && cc < n && !seed[cr][cc]) {
                r = cr;
                c = cc;
            }else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return matrix;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[][] m = solution.generateMatrix(5);

        for (int i = 0 ; i< m.length ; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }
}
