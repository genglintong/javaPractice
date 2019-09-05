package com.company.medium._063;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.SoapBindingStyle;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/unique-paths-ii/
 * </p>
 * DATE 2019/9/5.
 *
 * @author genglintong.
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        if (n == 0) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 1 ; i < m + n ; i++) {
            int di = i , dj = 0;
            while (di >= 0) {
                if (di < m && dj < n) {
                    if (obstacleGrid[di][dj] == 1) {
                        dp[di][dj] = 0;
                    }else {
                        if (di == 0) {
                            dp[di][dj] = dp[di][dj - 1];
                        }else if (dj == 0) {
                            dp[di][dj] = dp[di-1][dj];
                        }else {
                            dp[di][dj] = dp[di][dj - 1] + dp[di-1][dj];
                        }
                    }
                }

                dj++;
                di--;
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        }));
    }
}
