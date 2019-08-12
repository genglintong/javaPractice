package com.company.medium._006;

/**
 * @author genglintong
 * @package com.company.medium._006
 * @desc
 * @date 2019/8/12
 */
public class Solution {
    public String convert(String s , int numRows) {
        if (numRows <= 1) return s;

        int len = s.length();
        int[][] conv = new int[len][numRows];
        int type[][] = {{0,1},{1,-1}};

        int x = 0 , y = 0 , t = 0;
        for (int i = 0 ; i < len ; i++) {
            conv[x][y] = (int) s.charAt(i);
            x += type[t][0];
            y += type[t][1];

            if (y >= numRows - 1 || y <= 0) {
                t = (t+1) % 2;
            }
        }

        StringBuilder newS = new StringBuilder();
        for (int i = 0 ; i < numRows ; i++) {
            for (int j = 0 ; j < len ; j++) {
                if (conv[j][i] != 0) {
                    newS.append((char)conv[j][i]);
                }
            }
        }
        return newS.toString();
    }

    public String converOpti(String s, int numRows) {
        if (numRows <= 1) return s;

        int len = s.length();
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        int i = 0;
        while (i < len) {
            for (int j = 0; j < numRows && i < len; j++) {
                sbs[j].append(s.charAt(i++));
                //System.out.println(i + " " + j);
            }

            for (int j = numRows - 2 ; j >= 1 && i < len ; j--) {
                sbs[j].append(s.charAt(i++));
                //System.out.println(i + " " + j);
            }
        }

        for (int j = 1 ; j < numRows ; j++) {
            sbs[0].append(sbs[j]);
        }
        return sbs[0].toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.converOpti("LEETCODEISHIRING", 3));// PAHNAPLSIIGYIR
        System.out.println(solution.convert("ABCD", 4));
    }
}
