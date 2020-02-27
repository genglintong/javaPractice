package com.company.easy._700._704;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/binary-search/
 * </p>
 * DATE 2020/2/27.
 *
 * @author genglintong.
 */
public class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length, s = 0 , e = len - 1, mid;

        while (s <= e) {
            mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target) {
                e = mid - 1;
            }else {
                s = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{0,2,3,9,10}, 9));
    }
}
