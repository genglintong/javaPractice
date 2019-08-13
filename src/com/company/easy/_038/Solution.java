package com.company.easy._038;

import java.util.ArrayList;

/**
 * @author genglintong
 * @package com.company.easy._038
 * @desc
 * @date 2019/8/13
 */
public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";

        StringBuilder[] str = new StringBuilder[n];
        for(int i = 0; i < n ; i++) {
            str[i] = new StringBuilder();
        }

        str[0].append('1');

        for (int i = 1; i < n ; i++) {
            int num = 0;
            char[] strC = str[i-1].toString().toCharArray();
            int sL = strC.length;
            for (int j  = 0 ; j < sL ; j++) {
                if (j == 0 || strC[j] == strC[j-1]) {
                    num++;
                }else {
                    str[i].append(num + "" + strC[j-1]);
                    num = 1;
                }
            }
            str[i].append(num + "" + strC[sL-1]);
        }

        return str[n-1].toString();
    }

    public String countAndSayOpti(int n) {
        if (n <= 0) return "";

        String str = "1";
        while (--n > 0) {
           StringBuilder newS = new StringBuilder();
           char[] charS = str.toCharArray();
           int num = 0, len = charS.length;

           for (int i = 0 ; i < len ; i++) {
               if (i == 0 || charS[i] == charS[i-1]) {
                   num++;
               }else {
                   newS.append(num).append(charS[i-1]);
                   num = 1;
               }
           }
           newS.append(num).append(charS[len-1]);
           str = newS.toString();
        }

        return str;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSayOpti(6));
    }
}
