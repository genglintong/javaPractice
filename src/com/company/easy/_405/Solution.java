package com.company.easy._405;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/
 * </p>
 * DATE 2020/2/9.
 *
 * @author genglintong.
 */
public class Solution {
    public String toHex(int num) {
        long n = num;
        if (n < 0) {
            n = 0xffffffffL + n + 1;
        }else if (n == 0) {
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();
        char c;

        while (n != 0 && stringBuilder.length() < 8) {
            long t = n % 16;
            n = n / 16;
            if (t >= 10) {
                c = (char) (t - 10 + 'a');
                stringBuilder.insert(0, c);
            }else {
                stringBuilder.insert(0, t);
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.toHex(26));
        System.out.println(solution.toHex(-1));
    }
}
