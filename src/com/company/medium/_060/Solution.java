package com.company.medium._060;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/permutation-sequence/
 * </p>
 * DATE 2019/9/4.
 *
 * @author genglintong.
 */
public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder str = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        int s = 1;
        for (int i = 1 ; i < n ; i++) {
            list.add(i);
            s *= i;
        }
        list.add(n);

        while (n > 1) {
            int t = k / s;
            k = k % s;
            s = s / --n;

            if (k == 0) {
                str.append(list.get(t-1));
                list.remove(t-1);
                break;
            }
            str.append(list.get(t));
            list.remove(t);
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            str.append(list.get(i));
        }

        return str.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.getPermutation(3,3));
    }
}
