package com.company.easy._693;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/binary-number-with-alternating-bits/
 * </p>
 * DATE 2020/2/25.
 *
 * @author genglintong.
 */
public class Solution {
    public boolean hasAlternatingBits(int n) {
        int m = n << 1;

        if ((n & 1) == 0) {
            m++;
        }
        m += n;
        return (m & (m+1)) == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasAlternatingBits(5));
    }
}
