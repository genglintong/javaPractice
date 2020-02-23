package com.company.easy._661;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/image-smoother/
 * </p>
 * DATE 2020/2/23.
 *
 * @author genglintong.
 */
public class Solution {
    public int[][] imageSmoother(int[][] M) {
        int m = M.length, n;

        if (m <= 0) return M;
        n = M[0].length;

        int[][] res = new int[m][n];

        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                int count = 0;
                for (int nr = i-1; nr <= i+1; ++nr)
                    for (int nc = j-1; nc <= j+1; ++nc) {
                        if (0 <= nr && nr < m && 0 <= nc && nc < n) {
                            res[i][j] += M[nr][nc];
                            count++;
                        }
                    }
                res[i][j] /= count;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] res = solution.imageSmoother(new int[][]{
                {}
        });
    }
}
