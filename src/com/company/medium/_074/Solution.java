package com.company.medium._074;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/search-a-2d-matrix/
 * </p>
 * DATE 2019/9/6.
 *
 * @author genglintong.
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m <= 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n <= 0) {
            return false;
        }
        int len = m * n;
        int start = 0 , end = len - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int i = mid/n, j = mid % n;
            //System.out.println(start + " " + end + " " + i + " " + j + " " + mid);
            if (matrix[i][j] == target) {
                return true;
            }else if (matrix[i][j] > target){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(new int[][]{
                {1,3,5,7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 3));
    }
}
