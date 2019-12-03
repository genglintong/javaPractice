package com.company.easy._231;

/**
 * Description
 * <p>
 * </p>
 * DATE 2019/12/3.
 *
 * @author genglintong.
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        if ((n & 1) != 0) {
            return false;
        }
        return isPowerOfTwo(n >> 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isPowerOfTwo(2));
    }
}
