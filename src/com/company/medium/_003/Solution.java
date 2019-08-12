package com.company.medium._003;

/**
 * @author genglintong
 * @package com.company.medium._003
 * @desc
 * @date 2019/8/8
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length(), preP = 0, max = 0;
        if (len <= 1) {
            return len;
        }

        int[] hash = new int[128];


        for (int i = 0 ; i < len ; i++) {
            char c = s.charAt(i);
            if (hash[c] > preP) {
                preP = hash[c];
            }

            int l = i + 1 - preP;
            hash[c] = i + 1;

            if (l > max) {
                max = l;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.lengthOfLongestSubstring("abcabcabc"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("asanklnsannsal"));
    }
}
