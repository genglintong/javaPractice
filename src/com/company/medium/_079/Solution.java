package com.company.medium._079;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/word-search/
 * </p>
 * DATE 2019/9/9.
 *
 * @author genglintong.
 */
public class Solution {
    private int[][] d = {{1,0,-1,0},{0,1,0,-1}};
    private boolean[][] isEmpty;
    private char[] wArray;
    private int len;
    private int m ;
    private int n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m <= 0) {
            return false;
        }
        n = board[0].length;
        if (n <= 0) {
            return false;
        }
        wArray = word.toCharArray();
        len = wArray.length;
        if (len <= 0 ) {
            return false;
        }

        isEmpty = new boolean[m][n];

        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                boolean isExist = dfs(board,i,j,0);
                if (isExist) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i , int j , int start) {
        if (start == len - 1) {
            return board[i][j] == wArray[start];
        }
        if (board[i][j] == wArray[start]) {
            isEmpty[i][j] = true;
            for (int t = 0 ; t < 4 ; t++) {
                int di = i + d[0][t], dj = j + d[1][t];
                if (di >= 0 && di < m && dj >= 0 && dj < n && !isEmpty[di][dj]) {
                    if (dfs(board, di, dj, start + 1)) {
                        return true;
                    }
                }
            }
            isEmpty[i][j] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.exist(new char[][] {
                {'A', 'S', 'C', 'E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        }, "ASA"));
    }
}
