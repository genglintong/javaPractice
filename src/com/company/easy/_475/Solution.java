package com.company.easy._475;

import java.util.Arrays;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/heaters/
 * </p>
 * DATE 2020/2/14.
 *
 * @author genglintong.
 */
public class Solution {
    /**
     * 1. 找到每个房子最近的供暖器位置
     * 2. 取所有最近位置的 最大值
     *
     * 还可以更优，对house 排序，然后每次返回二分最近位置的index,下次可以排除
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius(int[] houses, int[] heaters) {
        int max = 0;
        Arrays.sort(heaters);

        for (int house : houses) {
            max = Math.max(max, findMin(house, heaters));
        }

        return max;
    }

    /**
     * 二分法 获取最近距离
     * @param house
     * @param heaters
     * @return
     */
    public int findMin(int house, int[] heaters) {
        int len = heaters.length, start = 0 , end = len-1, min = Integer.MAX_VALUE;
        if (heaters[start] >= house) return heaters[start] - house;
        if (heaters[end] <= house) return house - heaters[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            min = Math.min(min, Math.abs(heaters[mid] - house));

            if (min == 0) return min;
            if (heaters[mid] > house) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findRadius(new int[]{1,2,3}, new int[]{2}));
        System.out.println(solution.findRadius(new int[]{1,2,3,4}, new int[]{1,4}));
    }
}
