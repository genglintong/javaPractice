package com.company.easy._507;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/perfect-number/
 * </p>
 * DATE 2020/2/16.
 *
 * @author genglintong.
 */
public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 2) return false;
        int cur = 1, start = 2, end = num;
        while (start < end) {
            if (num % start == 0) {
                end = num / start;
                cur = cur + start + end;

                if (cur > num) return false;
            }
            start++;
        }

        return cur == num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkPerfectNumber(28));
    }
}
