package com.company.easy._119;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/pascals-triangle-ii/
 * </p>
 * DATE 2019/9/7.
 *
 * @author genglintong.
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0 ; i <= rowIndex ; i++) {
            List<Integer> res = new ArrayList<>();
            res.add(0,1);
            for (int j = 1; j < i ; j++) {
                res.add(j, list.get(j-1) + list.get(j));
            }
            if (i != 0) {
                res.add(i,1);
            }

            list = res;
        }

        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getRow(3));
    }
}
