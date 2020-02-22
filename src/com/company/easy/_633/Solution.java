package com.company.easy._633;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/sum-of-square-numbers/
 * </p>
 * DATE 2020/2/22.
 *
 * @author genglintong.
 */
public class Solution {
    public boolean judgeSquareSum(int c) {
        int end = (int) Math.sqrt(c) + 1, start = 0, res;

        while (start <= end) {
            res = start * start + end * end;
            if (res == c) return true;
            if (res > c) {
                end--;
            }else {
                start++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.judgeSquareSum(4));
    }
}
