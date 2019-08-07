package com.company.easy._028;

/**
 * @author genglintong
 * @package com.company.easy._028
 * @desc
 * @date 2019/8/7
 */
public class Solution {
    public int strStr(String haystack , String needle) {
        int l1 = haystack.length(), l2 = needle.length();

        if (l2 == 0) return 0;
        if (l1 < l2) return -1;

        for (int i = 0; i < l1; i++) {
            for (int j = 0 ; j < l2 ; j++) {
                if (i + j == l1) return -1;
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
                if (j+1 == l2) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Solution solution = new Solution();

        System.out.println(solution.strStr("hello","ll"));
    }
}
