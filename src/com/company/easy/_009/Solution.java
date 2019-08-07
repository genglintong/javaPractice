package com.company.easy._009;

/**
 * @author genglintong
 * @package com.company.easy._009
 * @desc   https://leetcode-cn.com/problems/palindrome-number/
 * @date 2019/8/7
 */
public class Solution {
    // 判断是否是 回文数
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        long t = 0, z = x;

        for (; x > 0 ; x /= 10) {
            t = t * 10 + x % 10;
        }

        return t == z;
    }

    public boolean isPalindromeOpti(int x) {
        // 剪枝
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int t = 0;
        while (t < x) {
            t = t * 10 + x % 10;
            x /= 10;
        }

        return (t == x) || (t / 10 == x);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(-121));
        System.out.println(solution.isPalindrome(1210));

        System.out.println(solution.isPalindromeOpti(121));
        System.out.println(solution.isPalindromeOpti(-121));
        System.out.println(solution.isPalindromeOpti(1210));
    }
}
