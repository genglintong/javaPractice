package com.company.easy._551;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/student-attendance-record-i/
 * </p>
 * DATE 2020/2/19.
 *
 * @author genglintong.
 */
public class Solution {
    public boolean checkRecord(String s) {
        int a = 0, l = 0;

        for (char c : s.toCharArray()) {
            if (c == 'L') {
                if (l >= 2) return false;
                l++;
            }else {
                l = 0;
            }
            if (c == 'A') {
                if (a != 0) return false;
                a++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkRecord("PPALLP"));
        System.out.println(solution.checkRecord("PPALLL"));
    }
}
