package com.company.medium._005;

/**
 * @author genglintong
 * @package com.company.medium._005
 * @desc
 * @date 2019/8/9
 */
public class Solution {

    /**
     * 使用动态规划
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();

        if (len <= 1) return s;

        boolean[][] dp = new boolean[len][len];
        int left = 0 , right = 0;

        for (int i = 0; i< len ; i++) {
            dp[i][i] = true;
            for (int j = i - 1; j >= 0; j--) {
                dp[j][i] = (s.charAt(i) == s.charAt(j) && ( i-j < 3 || dp[j+1][i-1]));

                if (dp[j][i] && (right - left) < (i - j)) {
                    right = i;
                    left = j;
                }
            }
        }

        return s.substring(left, right+1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("bab"));
        System.out.println(solution.longestPalindrome("aba"));
    }
}
