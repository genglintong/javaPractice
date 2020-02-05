package com.company.easy._326;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/power-of-three/
 * </p>
 * DATE 2020/2/5.
 *
 * @author genglintong.
 */
public class Solution {

    /**
     * 递归
     * @param n
     * @return
     */
    public boolean isPowerOfThree_1(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }

        if (n % 3 == 0) {
            return isPowerOfThree_1(n/3);
        }
        return false;
    }

    /**
     * 循环
     * @param n
     * @return
     */
    public boolean isPowerOfThree_2(int n) {
        if (n <= 0) {
            return false;
        }

        while (n != 1) {
            if (n % 3 != 0) {
                return false;
            }
            n = n / 3;
        }

        return true;
    }

    /**
     * 必须是一个质数
     * 整数限制 首先int 最大为 2^31 - 1 的最大3次幂为
     * @param n
     * @return
     */
    public boolean isPowerOfThree_3(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isPowerOfThree_1(27));
        System.out.println(solution.isPowerOfThree_2(27));
        System.out.println(solution.isPowerOfThree_3(27));
    }
}
