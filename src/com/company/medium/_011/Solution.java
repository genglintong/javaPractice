package com.company.medium._011;

/**
 * @author genglintong
 * @package com.company.medium._011
 * @desc https://leetcode-cn.com/problems/container-with-most-water/
 * @date 2019/8/13
 */
public class Solution {
    /**
     * 首尾逼近 长一直变小 保证高增长了 再进行max刷新即可
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int len = height.length;

        if (len <= 1) return 0;

        int l = 0 , r = len - 1, h = 0, max = 0;

        while (l < r) {
            h = Math.min(height[l], height[r]);
            max = Math.max(max, h * (r -l));

            //System.out.println(l + " " + r + " " + max + " " + h);
            while (height[l] <= h && l < r) l++;
            while (height[r] <= h && l < r) r--;
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[]{1, 2, 3, 2})); // 4
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));// 49
    }
}
