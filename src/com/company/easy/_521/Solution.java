package com.company.easy._521;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/longest-uncommon-subsequence-i/
 * </p>
 * DATE 2020/2/17.
 *
 * @author genglintong.
 */
public class Solution {
    /**
     * 相信自己 就是这么简单...
     * @param a
     * @param b
     * @return
     */
    public int findLUSlength(String a, String b) {
        if (a == b || a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLUSlength("", ""));
    }
}
