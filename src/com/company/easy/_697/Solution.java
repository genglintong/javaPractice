package com.company.easy._697;

import java.util.HashMap;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/degree-of-an-array/
 * </p>
 * DATE 2020/2/25.
 *
 * @author genglintong.
 */
public class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, ArrayInfo> hashMap = new HashMap<>(nums.length);
        int len = nums.length, maxNum = 0;
        ArrayInfo max = null;

        for (int i = 0 ; i < len ; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.get(nums[i]).add(i);
            }else {
                hashMap.put(nums[i], new ArrayInfo(i));
            }
        }

        for (ArrayInfo info : hashMap.values()) {
            if (max == null || max.num < info.num) {
                max = info;
                maxNum = info.max - info.min + 1;
            }else if (max.num == info.num) {
                maxNum = Integer.min(maxNum, info.max - info.min + 1);
            }
        }

        return maxNum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }
}

class ArrayInfo {
    public int num = 0;
    public int min = 0;
    public int max = 0;

    public ArrayInfo(int index) {
        this.min = index;
        this.num++;
        this.max = index;
    }

    public void add(int index) {
        this.num++;
        this.max = index;
    }
}
