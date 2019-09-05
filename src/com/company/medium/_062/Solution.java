package com.company.medium._062;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/unique-paths/
 * </p>
 * DATE 2019/9/5.
 *
 * @author genglintong.
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int l = m + n - 2;
        m = Math.min(m,n) - 1;

        long res = 1, z = 1;
        for (int i = 0 ; i < m ; i++){
            res *= (l-i);
            z *= (i + 1);
        }

        return Integer.valueOf(String.valueOf(res/z));
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.print(solution.uniquePaths(10,10));
    }
}
