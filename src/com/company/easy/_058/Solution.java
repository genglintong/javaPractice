package com.company.easy._058;

/**
 * @author genglintong
 * @package com.company.easy._058
 * @desc  https://leetcode-cn.com/problems/length-of-last-word/
 * @date 2019/8/15
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int maxLen = 0 , pre = 0;
        for (int i = 0 ; i < len ; i++) {
            if (s.charAt(i) == ' ') {
                pre = (maxLen == 0) ? pre : maxLen;
                maxLen = 0;
            }else {
                maxLen++;
            }
        }

        return (maxLen == 0) ? pre : maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.lengthOfLastWord("Hello World"));
        System.out.println(solution.lengthOfLastWord("Hello "));
        System.out.println(solution.lengthOfLastWord("a   b     "));
    }
}
