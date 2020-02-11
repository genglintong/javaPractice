package com.company.easy._463;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/island-perimeter/
 * </p>
 * DATE 2020/2/11.
 *
 * @author genglintong.
 */
public class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0, len1 = grid.length, len2 = grid[0].length;

        for (int i = 0 ; i < len1 ; i++) {
            for (int j = 0 ; j < len2 ; j++) {
                if ((grid[i][j] == 1 && (j == 0 || grid[i][j-1] == 0))) {
                    res += 2;
                }
            }
        }

        for (int i = 0 ; i < len2 ; i++) {
            for (int j = 0 ; j < len1 ; j++) {
                if ((grid[j][i] == 1 && (j == 0 || grid[j-1][i] == 0))) {
                    res += 2;
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.islandPerimeter(new int[][]{
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        }));
    }
}
