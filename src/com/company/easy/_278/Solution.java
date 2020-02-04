package com.company.easy._278;

import javax.swing.*;

/**
 * Description
 * <p>
 *     折半查找
 *     https://leetcode-cn.com/problems/first-bad-version/submissions/
 * </p>
 * DATE 2020/2/4.
 *
 * @author genglintong.
 */
public class Solution extends VersionControl{
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            /**
             * 超时
             * mid = (start + end) / 2;
             */
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)) {
                end = mid;
            }else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstBadVersion(10));
    }
}

class VersionControl {
    static int badVersion = 3;
    public boolean isBadVersion(int version) {
        return (version >= badVersion);
    }
}
