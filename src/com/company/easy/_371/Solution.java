package com.company.easy._371;

/**
 * Description
 * <p>
 * </p>
 * DATE 2020/2/6.
 *
 * @author genglintong.
 */
public class Solution {
    /**
     * a + b = a ^ b + (a & b) << 1;
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getSum(3,5));
        System.out.println(solution.getSum(3,-2));
    }
}
