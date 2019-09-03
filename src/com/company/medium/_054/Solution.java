package com.company.medium._054;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author genglintong
 * @package com.company.medium._054
 * @desc https://leetcode-cn.com/problems/spiral-matrix/
 * @date 2019/8/30
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length;
        if (n <= 0) {
            return list;
        }
        int t = n / 2;
        return Collections.emptyList();
    }

    public static void main(String[] args) {

    }
}
