package com.company.easy._441;

/**
 * Description
 * <p>
 * </p>
 * DATE 2020/2/10.
 *
 * @author genglintong.
 */
public class Solution {
    public int arrangeCoins(int n) {
        long temp = 0, i = 1;
        while (temp < n) {
            temp = (i + 1) * i / 2;
            i++;
        }

        return (int) ((temp == n) ? i - 1 : i - 2);
    }

    public int arrangeCoinsOpti(int n) {
        return (int)(Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.arrangeCoins(5));
        System.out.println(solution.arrangeCoins(6));
    }
}
