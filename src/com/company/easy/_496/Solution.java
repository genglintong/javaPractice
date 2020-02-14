package com.company.easy._496;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/next-greater-element-i/
 * </p>
 * DATE 2020/2/14.
 *
 * @author genglintong.
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums2.length);

        for (int i = 0 ; i < nums2.length; i++) {
            hashMap.put(nums2[i], -1);
            for (int j = i+1; j < nums2.length; j++) {
                if (nums2[j] > nums2[i]) {
                    hashMap.put(nums2[i], nums2[j]);
                    break;
                }
            }
        }

        int[] res = new int[nums1.length];
        for (int i = 0 ; i < nums1.length ; i++) {
            res[i] = hashMap.get(nums1[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
    }
}
