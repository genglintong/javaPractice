package com.company.medium._034;

import java.util.Arrays;

/**
 * @author genglintong
 * @package com.company.medium._034
 * @desc https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @date 2019/8/21
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] start = {-1, -1};
        int i = 0 , j = nums.length - 1, index = -1, len = nums.length;

        while (i <= j) {
            int mid = (i + j) / 2;

            if (nums[mid] == target) {
                index = mid;
                break;
            }
            if (nums[mid] > target) {
                j = mid - 1;
            }else {
                i = mid + 1;
            }
        }

        //System.out.println(index);
        if (index == -1) {
            return start;
        }

        start[0] = index;
        start[1] = index;

        //System.out.println(Arrays.toString(start));

        while (start[1] < len && nums[start[1]] == target) {
            start[1]++;
        }
        while (start[0] != -1 && nums[start[0]] == target) {
            start[0]--;
        }
        start[1]--;
        start[0]++;

        return start;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.searchRange(new int[]{1}, 1)));
    }
}
