package com.company.easy._088;

import java.util.Arrays;

/**
 * @author genglintong
 * @package com.company.easy._088
 * @desc https://leetcode-cn.com/problems/merge-sorted-array/
 * @date 2019/8/26
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mm;
        while (n > 0) {
            mm = (m > 0) ? nums1[m-1] : Integer.MIN_VALUE;

            //System.out.println(nums2[n-1] + " " + mm);
            if (mm > nums2[n-1]) {
                nums1[n + m - 1] = mm;
                m--;
            }else {
                nums1[n + m - 1] = nums2[n - 1];
                n--;
            }
            //System.out.println(Arrays.toString(nums1));
        }
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        solution.merge(nums1, 3, new int[]{2,5,6}, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
