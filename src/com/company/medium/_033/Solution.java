package com.company.medium._033;

/**
 * @author genglintong
 * @package com.company.medium._033
 * @desc https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * @date 2019/8/21
 */
public class Solution {
    public int search(int[] nums, int target) {
        int i = 0 , j = nums.length - 1;

        while (i <= j) {
            // 主要是边界问题的判断
            //System.out.println(i + " " + j);
            int mid = (i + j) / 2;

            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] <= nums[j]) {
                //System.out.println("sss");
                if (nums[j] >= target && nums[mid] < target) {
                    i = mid + 1;
                }else {
                    j = mid - 1;
                }
            }else {
                if (nums[mid] > target && nums[i] <= target) {
                    j = mid - 1;
                }else {
                    i = mid + 1;
                }
            }
            //System.out.println(i + " " + j);
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.search(new int[]{5,1,3}, 3));
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 0));
        //System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 3));
    }
}
