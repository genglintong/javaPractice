package com.company.easy._492;

import java.util.Arrays;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/construct-the-rectangle/
 * </p>
 * DATE 2020/2/14.
 *
 * @author genglintong.
 */
public class Solution {
    public int[] constructRectangle(int area) {
        int s = (int) Math.sqrt(area), a;
        if (s * s != area) {
            s++;
        }

        for (int i = s ; i >= 1 ; i--) {
            if (area%i == 0) {
                a = area/i;
                if (a > i) {
                    return new int[]{a, i};
                }else {
                    return new int[]{i, a};
                }
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.constructRectangle(4)));
    }
}
