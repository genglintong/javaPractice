package com.company.easy._014;

/**
 * @author genglintong
 * @package com.company.easy._014
 * @desc https://leetcode-cn.com/problems/longest-common-prefix/
 * @date 2019/8/7
 */
public class Solution {
    // 字符串遍历
    public String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE, len = strs.length;

        if (len <= 0) {
            return "";
        }

        for (String s: strs) {
            minLen = Math.min(minLen, s.length());
        }

        for (int i = 0; i < minLen; i++) {
            for (int j = 1; j < len ; j++) {
                if (strs[j].charAt(i) != strs[j-1].charAt(i)) {
                    //System.out.println(i);
                    // 字符串截取 包括begin index 不包括 end index
                    return strs[j].substring(0,i);
                }
            }
        }

        return strs[0].substring(0,minLen);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}
