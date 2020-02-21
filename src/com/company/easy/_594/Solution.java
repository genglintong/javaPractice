package com.company.easy._594;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/longest-harmonious-subsequence/
 * </p>
 * DATE 2020/2/21.
 *
 * @author genglintong.
 */
public class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);
        int res = 0 ;

        for (int n : nums) {
            hashMap.put(n , hashMap.getOrDefault(n, 0) + 1);
            if (hashMap.containsKey(n-1)) {
                res = Math.max(res, hashMap.get(n) + hashMap.get(n-1));
            }

            if (hashMap.containsKey(n+1)) {
                res = Math.max(res, hashMap.get(n) + hashMap.get(n+1));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLHS(new int[]{1,3,2,2,5,2,3,7}));
    }
}
