package com.company.easy._035;

/**
 * @author genglintong
 * @package com.company.easy._035
 * @desc https://leetcode-cn.com/problems/search-insert-position
 * @date 2019/8/13
 */
public class Solution {
    public int searchInsert(int[] nums, int target)
    {
        int len = nums.length;

        if (len <= 0 ) return 0;

        //System.out.println(len);
        for (int i = 0 ; i < len ; i++) {
            //System.out.println(i + " " + nums[i]);
            if (nums[i] >= target) {
                return i;
            }
        }

        return len;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();

        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 9));
    }
}
