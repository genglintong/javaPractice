package com.company.easy._506;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/relative-ranks/
 * </p>
 * DATE 2020/2/16.
 *
 * @author genglintong.
 */
public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int[] nn = nums.clone();
        Arrays.sort(nn);
        int len = nums.length;
        HashMap<Integer, String> hashMap = new HashMap<>(len);
        String res;
        String[] result = new String[len];

        for (int i = 0; i < len ; i++) {
            if (len - i == 1) {
                res = "Gold Medal";
            }else if (len - i == 2) {
                res = "Silver Medal";
            }else if (len - i == 3) {
                res = "Bronze Medal";
            }else {
                res = String.valueOf(len - i);
            }
            hashMap.put(nn[i], res);
        }

        for (int i = 0 ; i < len ; i++) {
            result[i] = hashMap.get(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findRelativeRanks(new int[]{5,2,3,1,4})));
    }
}
