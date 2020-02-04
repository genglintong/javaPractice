package com.company.easy._299;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/bulls-and-cows/
 * </p>
 * DATE 2020/2/4.
 *
 * @author genglintong.
 */
public class Solution {
    public String getHint(String secret, String guess) {
        int[] nums_G = new int[10], nums_S = new int[10];
        int numA = 0, numB = 0;
        char[] chars_S = secret.toCharArray();
        char[] chars_G = guess.toCharArray();

        for (int i = 0 ; i < chars_G.length ; i++) {
            nums_S[(chars_S[i] - '0')]++;
            nums_G[(chars_G[i] - '0')]++;
            if (chars_G[i] == chars_S[i]) {
                numA++;
            }
        }

        for (int i  = 0 ; i < 10 ; i++) {
            numB += Math.min(nums_G[i], nums_S[i]);
        }
        return numA + "A" + (numB - numA) + "B";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.getHint("1807", "7810"));
        System.out.println(solution.getHint("1123", "0111"));
    }
}
