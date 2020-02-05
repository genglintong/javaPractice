package com.company.easy._349;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * </p>
 * DATE 2020/2/5.
 *
 * @author genglintong.
 */
public class Solution {
    /**
     * 排序 OR 使用HASH
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n1 = nums1.length, n2 = nums2.length;
        int len = n1 + n2;
        HashSet<Integer> set = new HashSet<>(len);

        int s1 = 0 , s2 = 0;
        for (int i = 0 ; i < len ; i++) {
            if (s1 < n1 && s2 < n2) {
                if (nums1[s1] == nums2[s2]) {
                    set.add(nums1[s1]);
                    s2++;
                    s1++;
                }else if (nums1[s1] > nums2[s2]) {
                    s2++;
                }else {
                    s1++;
                }
            }
        }

        len = set.size();
        Object[] list = set.toArray();
        int[] integers = new int[len];
        for (int i = 0 ; i < len; i++) {
            integers[i] = (int)list[i];
        }
        return integers;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }
}
