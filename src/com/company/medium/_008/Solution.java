package com.company.medium._008;

/**
 * @author genglintong
 * @package com.company.medium._008
 * @desc
 * @date 2019/8/12
 */
public class Solution {
    public int myAtoi(String str) {
        int len = str.length();
        if (len <= 0) return 0;
        char[] strC = str.toCharArray();

        int start = 0 , t = 1;
        long z = 0;

        while (start < len && strC[start] == ' ') {
            start++;
        }
        if (start >= len) return 0;

        if (!judgeInt(strC[start])) {
            if (strC[start] == '-') {
                t = -1;
            } else if (strC[start] != '+'){
                return 0;
            }
        } else {
            z = strC[start] - '0';
        }

        while (++start < len) {
            if (!judgeInt(strC[start])) {
                return (int) (z * t);
            }
            z = z * 10 + (strC[start] - '0');
            if (z > Integer.MAX_VALUE) {
                return t > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            //System.out.println(z);
        }
        return (int) (z * t);
    }

    private boolean judgeInt(char c) {
        return (c >= '0' && c <= '9');
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("1"));
        //System.out.println(solution.myAtoi("4193 with words"));
        //System.out.println(solution.myAtoi("-91283472332"));
    }
}
