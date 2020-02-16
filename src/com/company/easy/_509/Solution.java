package com.company.easy._509;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/fibonacci-number/
 * </p>
 * DATE 2020/2/16.
 *
 * @author genglintong.
 */
public class Solution {
    public int fib(int N) {
        if (N == 0) return 0;
        int pre = 0, cur = 1;
        while (N-- > 1) {
            cur += pre;
            pre = cur - pre;
        }

        return cur;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(10));
    }
}
