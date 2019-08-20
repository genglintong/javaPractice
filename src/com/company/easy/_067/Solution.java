package com.company.easy._067;

/**
 * @author genglintong
 * @package com.company.easy._067
 * @desc https://leetcode-cn.com/problems/add-binary/
 * @date 2019/8/20
 */
public class Solution {
    public String addBinary(String a, String b) {
        char[] cA , cB ;
        int lenA = a.length(), lenB = b.length();

        if (lenA < lenB) {
            cA = b.toCharArray();
            cB = a.toCharArray();
            lenA = b.length();
            lenB = a.length();
        }else {
            cA = a.toCharArray();
            cB = b.toCharArray();
        }

        int judge = 0, i = 0;
        while ((i < lenB || judge > 0) && i < lenA) {
            cA[lenA - i - 1] += ((i < lenB) ? (cB[lenB - i - 1] - '0') : 0) + judge;
            if (cA[lenA - i - 1] > '1') {
                cA[lenA - i - 1] = (char) (cA[lenA - i - 1] - 2);
                judge = 1;
            }else {
                judge = 0;
            }
            //System.out.println(cA[lenA - i - 1]);
            i++;
        }

        String str = new String(cA);
        if (judge > 0) {
            str = "1" + str;
        }
        return str;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("1010", "1011"));
    }
}
