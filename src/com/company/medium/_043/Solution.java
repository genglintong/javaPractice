package com.company.medium._043;

import java.util.Arrays;

/**
 * @author genglintong
 * @package com.company.medium._043
 * @desc https://leetcode-cn.com/problems/multiply-strings/
 * @date 2019/8/28
 */
public class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int l1 = n1.length, l2 = n2.length;
        int[] r = new int[l1 + l2];

        if (l1 == 0 || l2 == 0) {
            return res.toString();
        }

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        for (int i = l1 - 1 ; i >= 0 ; i--) {
            for (int j = l2 - 1 ; j >= 0 ; j--) {
                int temp = (n2[j] - '0') * (n1[i] - '0') + r[i+j+1];
                r[i+j] += temp / 10;
                r[i+j+1] = temp % 10;
            }
            //System.out.println(Arrays.toString(r));
        }

        boolean judge = true;
        for (int i = 0 ; i < l1 + l2 ; i++ ) {
            if (r[i] != 0) {
                judge = false;
            }
            if (r[i] == 0 && judge) {
                continue;
            }
            res.append(r[i]);
        }

        return res.toString();
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.multiply("999", "999"));
    }
}
