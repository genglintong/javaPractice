package com.company.easy._415;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/add-strings/
 * </p>
 * DATE 2020/2/10.
 *
 * @author genglintong.
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        char[] chars1 , chars2 ;
        int len1 = num1.length(), len2 = num2.length();

        if (len1 > len2) {
            chars1 = num2.toCharArray();
            chars2 = num1.toCharArray();
            len1 = chars1.length;
            len2 = chars2.length;
        }else {
            chars1 = num1.toCharArray();
            chars2 = num2.toCharArray();
        }

        StringBuilder stringBuilder = new StringBuilder();
        int start = 0, temp = 0, cur;

        while (++start <= len1 || temp != 0) {
            cur = temp;
            if (start <= len2) {
                cur += chars2[len2 - start] - '0';
            }

            if (start <= len1) {
                cur += chars1[len1 - start] - '0';
            }

            if (cur >= 10) {
                cur = cur - 10;
                temp = 1;
            }else {
                temp = 0;
            }
            stringBuilder.insert(0, cur);
        }

        if (start <= len2) {
            stringBuilder.insert(0, String.valueOf(chars2, 0, len2 - start + 1));
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addStrings("9133", "0"));
        System.out.println(solution.addStrings("0", "0"));
        System.out.println(solution.addStrings("999", "1"));
    }
}
