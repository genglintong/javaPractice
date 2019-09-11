package com.company.medium._081;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 * </p>
 * DATE 2019/9/9.
 *
 * @author genglintong.
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len <= 0) {
            return false;
        }
        int start = 0 , end = len - 1,  mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //if (nums[start] )
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
