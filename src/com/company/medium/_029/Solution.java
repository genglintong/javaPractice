package com.company.medium._029;

/**
 * @author genglintong
 * @package com.company.medium._029
 * @desc
 * @date 2019/8/16
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return  0;

        boolean t = false;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            t = true;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int z = 0;
        while (dividend > divisor) {
            z++;
            dividend -= divisor;
        }

        if (t) {
            z =  0 - z;
        }
        return z;
    }

    public int divideOpti(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long dvd = Math.abs((long) dividend);
        long dvr = Math.abs((long) divisor);
        int res = 0;

        while (dvd >= dvr) {
            long temp = dvr, multiple = 1;
            while (dvd > temp<<1) {
                temp <<= 1;
                multiple <<= 1;
            }
            dvd -= temp;
            res += multiple;
        }
        return (dividend > 0) ^ (divisor > 0) ? -res : res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(7,-3));
    }
}
