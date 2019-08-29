package com.company.medium._048;

/**
 * @author genglintong
 * @package com.company.medium._048
 * @desc https://leetcode-cn.com/problems/rotate-image/
 * @date 2019/8/29
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1) {
            return;
        }

        int len = n / 2;
        n = n -1;
        for (int i = 0; i < len ; i++){
            for (int j = i; j < n - i; j++) {
                //System.out.println(matrix[i][j] + " " + matrix[n-j][i] + " " + matrix[n-i][n-j] + " " + matrix[j][n-i]);
                int t = matrix[i][j];
                matrix[i][j] = matrix[n-j][i];
                matrix[n-j][i] = matrix[n-i][n-j];
                matrix[n-i][n-j] = matrix[j][n-i];
                matrix[j][n-i] = t;
            }
        }
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();

        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        solution.rotate(matrix);

        for (int i = 0 ; i < matrix.length; i++) {
            for (int j = 0 ; j < matrix[i].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
