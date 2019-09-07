package com.company.easy._118;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/pascals-triangle/
 * </p>
 * DATE 2019/9/7.
 *
 * @author genglintong.
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0 ; i < numRows ; i++) {
            List<Integer> res = new ArrayList<>();
            res.add(0,1);
            for (int j = 1; j < i ; j++) {
                res.add(j, list.get(i-1).get(j-1) + list.get(i-1).get(j));
            }
            if (i != 0) {
                res.add(i,1);
            }

            list.add(i,res);
        }

        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generate(10));
    }
}
