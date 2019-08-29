package com.company.medium._043;

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

        if (l1 == 0 || l2 == 0) {
            return res.toString();
        }

        /*int d = 0;
        for (int i = 1 ; i < l1 * l2 ; i++) {
            for (int j = 1 ; j <= i ; j++) {

            }
        }*/
        return "";
    }

    public static void main(String[] args)
    {

    }
}
