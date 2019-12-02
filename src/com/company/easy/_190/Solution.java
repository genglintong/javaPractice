package com.company.easy._190;

/**
 * Description
 * <p>
 * </p>
 * DATE 2019/11/30.
 *
 * @author genglintong.
 */
public class Solution {
    private int num = 32;

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0 ; i < num ; i++) {
            res = res << 1;
            res |= n & 1;
            n = n >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseBits(-3));
    }
}
