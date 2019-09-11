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
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target || nums[start] == target || nums[end] == target) {
                return true;
            }

            if (nums[start] == nums[mid]) {
                start++;
                continue;
            }
            // 前半部分有序
            if (nums[start] < nums[mid]) {
                if (nums[start] < target && nums[mid] > target) {
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[end] > target) {
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{2,5,6,0,0,1,2}, 0));
    }
}
