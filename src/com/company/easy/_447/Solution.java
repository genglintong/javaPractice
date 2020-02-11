package com.company.easy._447;

import java.util.HashMap;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/number-of-boomerangs/
 * </p>
 * DATE 2020/2/11.
 *
 * @author genglintong.
 */
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        if (n < 3) {
            return 0;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>(n);
        int l , res = 0;

        for (int i = 0 ; i < n ; i++) {
            hashMap = new HashMap<>(n);
            for (int j = 0 ; j < n ; j++) {
                l = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                if (hashMap.containsKey(l)) {
                    hashMap.put(l ,hashMap.get(l)+1);
                }else {
                    hashMap.put(l , 1);
                }
            }

            for (Integer t : hashMap.values()) {
                if (t >=2 ) {
                    res += t * (t-1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.numberOfBoomerangs(new int[][]{{0,0}, {1,0}, {2,0}}));
        System.out.println(solution.numberOfBoomerangs(new int[][]{{0,0}, {1,0}, {-1,0}, {0, 1}, {0, -1}}));
    }
}
