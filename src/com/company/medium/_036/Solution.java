package com.company.medium._036;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author genglintong
 * @package com.company.medium._036
 * @desc https://leetcode-cn.com/problems/valid-sudoku/
 * @date 2019/8/26
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet [] rows = new HashSet[9];
        HashSet [] columns = new HashSet[9];
        HashSet [] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Integer>();
            columns[i] = new HashSet<Integer>();
            boxes[i] = new HashSet<Integer>();
        }

        int r = board.length, c = board[0].length;
        for (int i = 0 ; i < r; i++) {
            for (int j = 0 ; j < c ; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int box = (i / 3 ) * 3 + j / 3;
                    int n = (int)num;

                    if (rows[i].contains(n) || columns[j].contains(n) || boxes[box].contains(n)) {
                        return false;
                    }
                    rows[i].add(n);
                    columns[j].add(n);
                    boxes[box].add(n);
                }
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.isValidSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        }));
    }
}
