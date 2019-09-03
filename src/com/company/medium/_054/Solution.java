package com.company.medium._054;

import java.util.ArrayList;
import java.util.List;

/**
 * @author genglintong
 * @package com.company.medium._054
 * @desc https://leetcode-cn.com/problems/spiral-matrix/
 * @date 2019/8/30
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int mR = matrix.length;

        if (mR == 0) {
            return list;
        }

        int mC = matrix[0].length;
        boolean[][] seen = new boolean[mR][mC];
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};
        int r = 0, c = 0 , di = 0;

        for (int i = 0 ; i < mR * mC ; i++) {
            //System.out.println(r + " " + c);
            list.add(matrix[r][c]);
            seen[r][c] = true;

            int cr = r + dr[di], cc = c + dc[di];
            if (cr >= 0 && cr < mR && cc >= 0 && cc < mC && !seen[cr][cc]) {
                r = cr;
                c = cc;
            }else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.spiralOrder(new int[][]{
                {1,2,3,4,5},
                {1,2,3,4,5},
                {1,2,3,4,5},
                {1,2,3,4,5},
                {1,2,3,4,5}
        }));
    }
}
